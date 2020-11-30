<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="header">
    <header class="header_tit">
        <h1 class="logo">
            <a href="./main" class="lnk_logo" title="네이버">
               <span class="spr_bi ico_n_logo">네이버</span>
            </a>
            <a href="./main" class="lnk_logo" title="예약">
               <span class="spr_bi ico_bk_logo">예약</span>
            </a>
        </h1>
        <a href="./myreservation" class="btn_my">
            <span class="viewReservation" title="예약확인">
                <c:if test="${empty sessionScope.email}">예약확인</c:if>
                <c:if test="${!empty sessionScope.email}">${sessionScope.email}</c:if>
            </span>
        </a>
    </header>
</div>