<%@page import="org.lanqiao.service.impl.UserServiceImpl"%>
<%@page import="org.lanqiao.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserService us = new UserServiceImpl();
	request.setCharacterEncoding("UTF-8");
	us.exports(request.getParameter("url"));
	response.sendRedirect("txl.jsp");
%>