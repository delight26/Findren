<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


   <!-- 메인 네비 -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="findren headlogo">	
		<div class="maintop">
			<a href="/Findren/findren"><img src="resources/images/logo.png" class="logo"></a>
			<div id="loginjoin">
				<input class="main_msg" type="image"  src="resources/images/login.png" onclick="#">
				<input class="main_msg" type="image" src="resources/images/join.png">
			</div>
		</div>
	</div>
	    
	    
        <div class="maintop">
        	
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            
            <!-- 네비 메뉴 -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">회사소개<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="/Findren/comInfo">회사소개</a>
                            </li>
                            <li>
                                <a href="/Findren/comMainCustomer">주요고객군</a>
                            </li>
                            <li>
                                <a href="/Findren/comMap">오시는길</a>
                            </li>
                            <li>
                                <a href="/Findren/noticeList">공지사항</a>
                            </li>
                            <li>
                                <a href="/Findren/newsList">보도자료</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">사업분야<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="/Findren/comChinaMkt">중국마케팅</a>
                            </li>
                            <li>
                                <a href="/Findren/comOfficialAccount">위챗공중계정</a>
                            </li>
                            <li>
                                <a href="/Findren/comWechatPay">위챗페이</a>
                            </li>
                            <li>
                                <a href="/Findren/comJob">중국인채용</a>
                            </li>
                            <li>
                                <a href="/Findren/portfolioList">포트폴리오</a>
                            </li>
                            <li>
                                <a href="/Findren/promotionList">가맹점홍보</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">중국마케팅<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="/Findren/onlineList">온라인마케팅</a>
                            </li>
                            <li>
                                <a href="/Findren/snsList">SNS마케팅</a>
                            </li>
                            <li>
                                <a href="/Findren/seoList">SEO마케팅</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">위챗서비스<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">위챗공중계정</a>
                            </li>
                            <li>
                                <a href="#">위챗페이</a>
                            </li>
                            <li>
                                <a href="#">서비스신청</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">중국인채용<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">구인/구직</a>
                            </li>
                            <li>
                                <a href="#">헤드헌팅</a>
                            </li>
                            <li>
                                <a href="#">인력파견</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">광고신청</a>
                    </li>
                    <li>
                        <a href="#">근태관리</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
