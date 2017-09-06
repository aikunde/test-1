<%@page import="org.lanqiao.service.UserService"%>
<%@page import="org.lanqiao.service.impl.UserServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userid = request.getParameter("id");
	UserService us = new UserServiceImpl();
	us.delete(userid);
	response.sendRedirect("txl.jsp");
%>