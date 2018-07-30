<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@page import="java.text.DecimalFormat"%>
<%@ page import="retail.common.BaseEnv" %>
<%@ page import="retail.common.CommonUtil" %>
<%@ page import="retail.common.SessionModel" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="net.winis.common.util.WisComUtil" %>
<%@ page import="net.winis.servlet.util.WisServletUtil" %>

<%--
	파일명: inc_common.jsp
	설명:  jsp 공통 method 페이지
		
	작성일      수정자        
	------------------------------------------------------
	2016-10-25  문희훈        
	------------------------------------------------------
--%>    
<%!

HttpServletRequest req;
HttpServletResponse res;

/** 필수입력항목표시 마크 반환 */
String reqMark = "<span class='text_red'>*</span>";

/** null or zero space 여부 판단 */
boolean isEmpty(Object value) {
	return value == null || "".equals(value);
}

/** null 일 경우  대체값 반환 */
<D extends Object> D nvl(D value, D replacement) {
	return value == null ? replacement : value;
}

/** null 일 경우  대체값 반환 */
<D extends Object> D replace(D value, D compareValue, D replaceValue) {
	return nvl(value, "").equals(compareValue) ? replaceValue : value;
}

/** System.out 으로 format 되어진 메세지 출력 */
void println(Object... args) {
	WisComUtil.get().println(args);	
}

/** session 에 저장된 환경정보 반환 */
SessionModel getEnv() {
	return CommonUtil.getEnv(req.getSession());
}

/** response 에 no-chache header 추가 */
void setNocacheHeader() {
	WisServletUtil.get().setNocacheHeader(res);
}

/** no-chache meta tag 문자열 반환 */
String getNocacheMetaTags() {
	return WisServletUtil.get().getNochacheMetaTags();
}

/** 이름에 해당하는 첫번째  쿠기값 반환 */
String getCookie(String name) {
	Cookie[] cookies = req.getCookies();
	if(cookies != null) {
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(name)) {
				String value = cookie.getValue();
				if(value != null) {
// 					try {
						return URLDecoder.decode(value);
// 					} catch(Exception e) {}
				}
			}
		}
	}
	return "";
}

/** 쿠기값을 출력한다. */
void showCookies(HttpServletRequest request) {
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(Cookie cookie : cookies) {
			println("Cookie", "name:"+cookie.getName(), "value:"+cookie.getValue(), "domain:"+cookie.getDomain(), "path:"+cookie.getPath(), "maxAge:"+cookie.getMaxAge());
		}
	}
}

/** YYYY-MM-DD 형식 변환 */
String formatDate(String value, String separator) {
	String result = "";
	if(value != null && value.length() >= 8) {
		result = value.substring(0,4) + separator + value.substring(4,6) + separator + value.substring(6,8);
	}
	return result;
}

/** YYYY-MM-DD HH24:MI 형식 변환 */
String formatDateTime(String value, String separator) {
	String result = formatDate(value, separator);
	if(value != null && value.length() >= 12) {
		result += " " + value.substring(8,10) + ":" + value.substring(10,12);
	}
	return result;
}

/** forwarding */
void forward(String url) throws Exception {
	RequestDispatcher dispatcher = req.getRequestDispatcher(url);
	dispatcher.forward(req, res);
}

/**
 * '공통' 으로 사용되는 '숫자 포멧변환' Method
 * 'String 형태의 숫자와 원하는 포멧' 를 받아 '변환' 한다.
 * 포멧 사용 ex) "#,###" <-천단위마다 콤마
 * @param numberString
 * @param format
 * @return
 */
String numberFormatter(String numberString, String format) {
	
	int number = Integer.parseInt(numberString);
	DecimalFormat decimalFormat = new DecimalFormat(format);
	String result = (String)decimalFormat.format(number);
	
	return result;
	
}

String numberFormatter(Double number, String format) {
	
	DecimalFormat decimalFormat = new DecimalFormat(format);
	String result = (String)decimalFormat.format(number);
	
	return result;
	
}

%>

<%
this.req = request;
this.res = response;
%>
   
<%
String redirectURL = "/goLogin.do"; // login.do
if(getEnv().getUser_name() == null){
	response.sendRedirect(redirectURL);	
}
%>
 