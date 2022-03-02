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
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- owl stylesheets --> 
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">

    </head>
    <body>
        <!--header section start -->
        <div id="index.jsp" class="header_section">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-3">
                        <div class="logo"></div>
                    </div>
                    <div class="col-sm-6 col-lg-9">
                        <div class="menu_text">
                            <ul>
                                <li><a href="#taxis"></a></li>
                                <li><a href="#booking"></a></li>
                                
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
                <div  class="carousel slide" >
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div class="row">
                                <div class="col-md-6">
                                    
                                    <div class="image_1"></div>
                                </div>
                                <div class="col-md-6">
                                    <h1 class="booking_text">Connexion</h1>
                                    <div class="contact_bg">
                                        <form action="${pageContext.request.contextPath}/login.do" method="post">
                                        <div class="input_main">
                                            <div class="container">
                                                <h2 class="request_text"></h2>
                                                
                                                    <div class="form-group">
                                                        <input type="email" class="email-bt" placeholder="Email" style="width: 400px" name="utilisateur.email">
                                                    </div>
                                                   
                                                    <div class="form-group">
                                                        <input type="password" class="email-bt" placeholder="Mot de passe" style="width: 400px" name="utilisateur.mdp">
                                                    </div>
                                                
                                            </div> 
                                        </div>
                                        <div class="send_bt"><a><button style="background-color: grey">SE CONNECTER</button></a></div></form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    
                </div>

            </div>
        </div>
        <!-- banner section end -->
       
        <!-- copyright section start -->
        <div class="copyright_section">
            <div class="container">
               </div>
        </div>

        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <!-- javascript --> 
        <script src="js/owl.carousel.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
       
    </body>
</html>