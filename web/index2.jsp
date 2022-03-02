<%@page import="modele.TypeContenu"%>
<%@page import="modele.Contenu"%>
<%@page import="java.util.List"%>
<% List liste = (List) request.getAttribute("liste");
    List l = (List) liste.get(0);
    List li = (List) liste.get(1);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>CONTENU</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">	
        <!-- bootstrap css -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="${pageContext.request.contextPath}/images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

    </head>
    <body>
        <!--header section start -->
        <div id="index.html" class="header_section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-3">
                        <div class="logo"></div>
                    </div>
                    <div class="col-sm-6 col-lg-9">
                        <div class="menu_text">
                            <ul>
                                <li><a href="#taxis">Contenu perso</a></li>
                                <li><a href="#booking">Contenu public</a></li>
                                <div id="myNav" class="overlay" >
                                    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
                                    <div class="overlay-content">
                                        <a href="#taxis">Taxi</a>
                                        <a href="#booking">Booking</a>
                                    </div>
                                </div>
                                <span  style="font-size:33px;cursor:pointer; color: #ffffff;" onclick="openNav()" >O</span>
                        </div>  
                        </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- header section end -->
        <!-- banner section start -->
        <div class="banner_section">
            <div class="container-fluid">
                <div id="main_slider" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="row">
                                <div class="col-md-6">

                                    <div class="image_1"></div>
                                </div>
                                <div class="col-md-6">
                                    <h1 class="booking_text">Rechercher un contenu</h1>
                                    <div class="contact_bg">
                                        <div class="input_main">
                                            <div class="container">
                                                <h2 class="request_text"></h2>
                                                <form action="${pageContext.request.contextPath}/recherche.do">
                                                    <div class="form-group">
                                                        <input type="date" class="email-bt" style="width: 200px" name="critere.un"><br> 
                                                        <input type="date" class="email-bt" style="width: 200px" name="critere.deux">
                                                    </div>

                                                    <div class="form-group">
                                                        <input type="text" class="email-bt" placeholder="Mot cle" style="width: 200px" name="critere.keyword">
                                                    </div>
                                                    <div class="send_bt"><a href="#"><button style="background-color: #3B3B3B">SEARCH</button></a></div>
                                                </form>
                                            </div> 
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div class="row">
                                <div class="col-md-6">

                                    <div class="image_1"></div>
                                </div>
                                <div class="col-md-6">
                                    <h1 class="booking_text">Ajouter un nouveau contenu</h1>
                                    <div class="contact_bg">
                                        <form action="${pageContext.request.contextPath}/insertContenu.do" method="post" enctype="multipart/form-data">
                                            <div class="input_main">
                                                <div class="container">
                                                    <h2 class="request_text"></h2>

                                                    <div class="form-group">
                                                        <% for (int i = 0; i < li.size(); i++) {
                                                                TypeContenu c = (TypeContenu) li.get(i);
                                                        %>
                                                        <input type="radio" style="width: 30px" value="<%=(c.getId())%>" name="contenu.typecontenuid"><% out.println(c.getNom()); %>
                                                        <% }%>

                                                    </div>

                                                    <div class="form-group">
                                                        <input type="text" class="email-bt" placeholder="Titre" style="width: 400px" name="contenu.titre">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="text" class="email-bt" placeholder="Description" style="width: 400px"  name="contenu.description">
                                                    </div>
                                                    <div class="form-group">
                                                        <input type="hidden" style="width: 400px" name="contenu.fichier">
                                                        <input type="file" class="email-bt" style="width: 400px;height: 50Px" name="contenu.fichier1">
                                                    </div>

                                                </div> 
                                            </div>

                                            <div class="send_bt"><a><input type="submit"  style="background-color: #3B3B3B" value="AJOUTER"></a></div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <a class="carousel-control-prev" href="#main_slider" role="button" data-slide="prev">
                        <i class="fa fa-angle-left"></i></a>
                    </a>
                    <a class="carousel-control-next" href="#main_slider" role="button" data-slide="next">
                        <i class="fa fa-angle-right"></i>
                    </a>
                    </a>
                </div>

            </div>
        </div>
        <!-- banner section end -->
        <!-- our taxis section start -->
        <div id="taxis" class="taxis_section layout_padding">
            <div class="container">
                <h1 class="our_text"><span style="color: #f4db31;"></span></h1>
                <div class="taxis_section_2">
                    <div class="row">
                        <% for (int i = 0; i < li.size(); i++) {
                                TypeContenu c = (TypeContenu) li.get(i);
                        %>
                        <div class="col-sm-3">
                            <div >
                                <form method="post" action="listeC.do">
                                    <input type="hidden" value="<%=c.getId()%>" name="contenu.typecontenuid">
                                    <button style="color: white;background-color: black;border-color: black;border-radius: 2px;width: 200px"> <% out.println(c.getNom()); %> </button>
                                </form></div>
                        </div>
                        <% }%> 
                    </div> 
                </div>
            </div>
        </div>
        <form method="post" action="listeAll.do">
            <input type="submit" style="color: white;background-color: black;border-color: black;border-radius: 2px;width: 100%" value="ALL">
        </form>


        <!-- our taxis section end -->
        <!-- why ride section start -->
        <div id="booking" class="ride_section layout_padding">
            <div class="container">
                <div class="ride_main">
                    <h1 class="ride_text">Contenu <span style="color: #f4db31;">Public</span></h1>
                </div>
            </div>
        </div>
        <div class="ride_section_2 layout_padding">

            <% for (int i = 0; i < l.size(); i++) {
                    Contenu c = (Contenu) l.get(i);
            %>
            <% if (i % 2 != 0) {%>
            <div class="container">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="image_3"><img src="${pageContext.request.contextPath}/images/<% out.println(c.getTypecontenuid()); %>.png"></div>
                    </div>
                    <div class="col-sm-8">
                        <h1 class="cabe_text"><% out.println(c.getTitre()); %></h1>
                        <p class="long_text"><% out.println(c.getDescription()); %></p>
                        <small><% out.println(c.getDatecontenu().toString().replace("-", ".")); %></small>
                        <div class="book_bt"><a href="http://localhost:8080/Contenu/fichier/<%=c.getFichier()%>" download><% out.println(c.getFichier()); %></a></div>
                    </div>
                </div>
            </div><% } %><% if (i % 2 == 0) {%>
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">
                        <h1 class="cabe_text"><% out.println(c.getTitre()); %></h1>
                        <p class="long_text"><% out.println(c.getDescription()); %></p>
                        <small><% out.println(c.getDatecontenu().toString().replace("-", ".")); %></small>
                        <div class="book_bt"><a href="http://localhost:8080/Contenu/fichier/<%=c.getFichier()%>"><% out.println(c.getFichier()); %></a></div>
                    </div>
                    <div class="col-sm-4">
                        <div class="image_3"><img src="${pageContext.request.contextPath}/images/<% out.println(c.getTypecontenuid()); %>.png"></div>
                    </div>
                </div>
            </div><% } %>
            <% }%>
        </div>
        <!-- why ride section end -->

        <!-- copyright section start -->
        <div class="copyright_section">
            <div class="container">
                <p class="copyright">2022 All Rights Reserved. <a href="https://html.design">ull@moov.fr</a></p>
            </div>
        </div>

        <!-- Javascript files-->
        <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/plugin.js"></script>
        <!-- sidebar -->
        <script src="${pageContext.request.contextPath}/js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/custom.js"></script>
        <!-- javascript --> 
        <script src="${pageContext.request.contextPath}/js/owl.carousel.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
        <script>
                                    $(document).ready(function () {
                                        $(".fancybox").fancybox({
                                            openEffect: "none",
                                            closeEffect: "none"
                                        });

                                        $(".zoom").hover(function () {

                                            $(this).addClass('transition');
                                        }, function () {

                                            $(this).removeClass('transition');
                                        });
                                    });
        </script> 
        <script>
            function openNav() {
                document.getElementById("myNav").style.width = "100%";
            }

            function closeNav() {
                document.getElementById("myNav").style.width = "0%";
            }
        </script>   
    </body>
</html>