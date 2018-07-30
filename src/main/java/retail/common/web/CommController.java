package retail.common.web;

import retail.common.BaseEnv;
import retail.common.service.CommService; 

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.tika.Tika;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ResponseBody;
  






import retail.common.service.FileVO;
import retail.common.EgovWebUtil;
import retail.common.EgovStringUtil;

/**
 * @project	RETAIL
 * @file	CommController.java
 * @comment
 * <pre>
 * </pre>
 *
 * @author	문희훈
 * @since	2016. 10. 24.
 */
@Controller
public class CommController {

	
	/** log */
	private final Log log = LogFactory.getLog(this.getClass());
	
	/** service */
	@Autowired 
	private CommService commService;
	
	
	/**
	 * @comment	첨부파일 목록 저장 : apache 제공 ServletFileUpload 이용 방법
	 * @param		request
	 * @param		response
	 * @return		
	 * @author		문희훈
	 * @since		2016. 10. 24.
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/saveAttachFileList.do")
	@ResponseBody
	public FileVO saveAttachFileList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// return FileVO
		FileVO result = new FileVO();
		// charset 설정
		response.setContentType("text/html; charset=utf-8");
		// 멀티파트인지 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// 멀티파트이면 파일목록만 저장한다.
		if ( isMultipart ) {
			// temporaryDir 설정
			File temporaryDir = new File(BaseEnv.FILE_PATH_TEMP);
			// 디렉토리가 없을경우 디렉토리 생성
			if ( !temporaryDir.isDirectory() ) {
				temporaryDir.mkdirs();
			}
			// 메모리나 파일로 업로드 파일 보관하는 FileItem의 Factory 설정
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 1메가가 넘지 않으면 메모리에 바로 사용
			factory.setSizeThreshold(BaseEnv.FILE_SIZE_THRESHOLD);
			// 1메가 이상이면 temporaryDir  경로 폴더로 이동
			factory.setRepository(temporaryDir);
			// 설정된 Factory 를 이용하여 업로드 할 파일의 크기 설정
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 업로드 크기제한 : 15MB
			upload.setSizeMax(BaseEnv.FILE_SIZE);
			// parameter 와 file 목록 parsing
			List items = null;
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException fe){
				System.out.println("FileUploadException Occured");
			}
			// 목록 존재시
			if ( items != null ) { 
				 
				// 파일소유자코드
				String fileOwner = null;
				// 유저 Type
				String userType = null;
				// 넘어온 formItem 구분
				Iterator formItems = items.iterator();
				while ( formItems.hasNext() ) {
					 
					FileItem formItem = (FileItem) formItems.next();
					// FormFiled 인 경우 parameter 처리
					if ( formItem.isFormField() ) {
						 
						// parameter 이름
						String fieldName = formItem.getFieldName().toLowerCase();
						// parameter 값
						String value = new String(formItem.getString().getBytes("ISO-8859-1"), "UTF-8");
 
						if ( "file_owner".equals(fieldName) ) {
							fileOwner = value;
						// 파일 Type
						} else if ( "user_type".equals(fieldName) ) {
							userType = value;
						}
					// FormFiled 가 아닌경우 파일이라고 본다.
					} else {
						// 파일 존재 하는지 체크. size > 0 이면 존재.
						if ( formItem.getSize() > 0 ) {
							 
							// 파일 이름 ( 확장자 포함 )
							String fileName = FilenameUtils.getName(formItem.getName());
							// 파일 첨부시 이름 ( 확장자 제거 )
							String orgFileNm = fileName.substring(0, fileName.lastIndexOf('.')); 
							// 파일 확장자
							String fileExt = FilenameUtils.getExtension(formItem.getName());
							// 파일 사이즈
							Long fileSize = formItem.getSize();
							// 파일경로
							String filePath = null;
							 
							 
							 filePath = "";	
							// 파일명은 Naming Convention에 의해서 생성							
							String fileNm = EgovStringUtil.getTimeStamp() + "_" + EgovStringUtil.getRandomString(10);
							// 파일 mime_type
							String mimeType = null;
							 try {
								// 디렉토리가 없을경우 디렉토리 생성
								File uploadDir = new File(EgovWebUtil.filePathBlackList(filePath));
								if ( !uploadDir.isDirectory() ) {
									uploadDir.mkdirs();
								}
								// 실제 디렉토리에 fileName으로 카피 된다.
								File uploadFile = new File(filePath, fileNm);
								// 파일정보로 해당경로에 파일 생성
								formItem.write(uploadFile);
								// 파일의 MIME_TYPE 읽기
								Tika tika = new Tika();
								mimeType = tika.detect(uploadFile);
								// 카피 완료후 temp폴더의 temp파일을 제거
								formItem.delete();
								// parameter 설정
								FileVO fileVO = new FileVO();
								fileVO.setFILE_PATH(filePath);
								fileVO.setFILE_NM(fileNm);
								fileVO.setFILE_SIZE(fileSize.intValue());   // 바이트
								fileVO.setFILE_EXT(fileExt);
								fileVO.setMIME_TYPE(mimeType);
								fileVO.setORG_FILE_NM(orgFileNm);
								fileVO.setFILE_OWNER(fileOwner);
								 
								 
								 
								 
								// 파일정보 저장 -  나중에 수정								
//								commService.saveAttachFile(fileVO);
//								List<FileVO> resultList = fileVO.get("result");
//								result = resultList.get(0);
								 
								
							} catch(IOException ex) {
								System.err.println("IOException Occured");
							}
								
						} else {
							// System.out.println("인코딩 타입이 multipart/form-data 가 아님.");
						}
					}
				}
			}
		}
		
		return result;
		
	}
	
	private String getBrowser(HttpServletRequest request) {
		
		String header = request.getHeader("User-Agent");
		
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) {	// IE11 문자열 깨짐 방지
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		
		return "Firefox";
	}

	
	/**
	 * Disposition 지정하기.
	 * 
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void setDisposition(String filename, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);
		
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;
		
		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) {		// IE11 문자열 깨짐 방지
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			throw new IOException("Not supported browser");
		}
		
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
		
		if ("Opera".equals(browser)){
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}
	
	/**
	 * 첨부파일로 등록된 파일에 대하여 다운로드를 제공한다.
	 * 
	 * @comment	파일 다운로드
	 * @param		request
	 * @param		response
	 * @return		
	 * @throws		Exception
	 * @author		문희훈
	 * @since		2016. 10. 24.
	 */
	@RequestMapping(value="/download.do", method=RequestMethod.POST)
	public void fileDownload(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 사용자 아이디
		String  user_id = request.getParameter("user_id");
		// 파일ID
		Integer fileId = Integer.parseInt(request.getParameter("fid"));
		
		// 파일경로
		String filePath = "";
		 
		filePath =  "";	
		
		// 파일소유코드 ( NA: 공지사항, BA: 게시판 )
		String fileOwnerCd = "";
		// 공지사항 번호
		Integer noticeNo = request.getParameter("nid") == null ? null : Integer.parseInt(request.getParameter("nid"));
		if ( noticeNo != null ) {
			fileOwnerCd = "NA";
		}
		// 게시판ID
		String boardId = request.getParameter("bid");
		if ( boardId != null ) {
			fileOwnerCd = "BA";
		}
		// 게시물ID
		Integer bulletinId = request.getParameter("id") == null ? null : Integer.parseInt(request.getParameter("id"));
		// parameter 설정
		FileVO params = new FileVO();
 
		 
		 
		
		// 파일 경로
		 
 		// 파일 이름
 		String fileNm =  request.getParameter("attch_filename");
 		
 		// 파일 첨부시 이름
 		String orgFileNm = request.getParameter("real_filename");
 		
 		if(orgFileNm == null || "".equals(orgFileNm)) return;
 		
 		orgFileNm = orgFileNm.replaceAll("\r", "").replaceAll("\n", "");
 		
 		// 파일 확장자
 		//String fileExt = "png"; 
 		
		// 다운받을 파일 설정
		String targetFile = filePath + fileNm;
		
		// System.out.println("targetFile:"+targetFile);  
		// 파일설정
		File uFile = new File(targetFile);
		int fSize = (int)uFile.length();
		
		if (fSize > 0) {
			String mimetype = "application/x-msdownload";
			
			response.setContentType(mimetype);
			setDisposition(orgFileNm , request, response);
			response.setContentLength(fSize);
			
			/*
			 * FileCopyUtils.copy(in, response.getOutputStream());
			 * in.close(); 
			 * response.getOutputStream().flush();
			 * response.getOutputStream().close();
			 */
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			
			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());
				
				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (IOException ex) {
				System.err.println("IOException Occured");
				//ex.printStackTrace();
				// 다음 Exception 무시 처리
				// Connection reset by peer: socket write error
//				log.debug("IGNORED: " + ex.getMessage());
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException ignore) {
						System.err.println("IOException Occured");
						// no-op
//						log.debug("IGNORED: " + ignore.getMessage());
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException ignore) {
						// no-op
						System.err.println("IOException Occured");
//						log.debug("IGNORED: " + ignore.getMessage());
					}
				}
			}
		
		} else {
			
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter printwriter = response.getWriter();
			printwriter.println("<script>");
			printwriter.println("alert('선택한 파일정보가 없습니다. 관리자에게 문의하세요.');");
			printwriter.println("</script>");
			
		}
		
	}
	
	
	 
	
	
	
	 
	
}
