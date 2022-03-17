<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
      type="text/javascript"
    ></script>
    <link href="<c:url value="/Resources/Content/LoginStyle.css" />"
	rel="stylesheet">
    <script src="<c:url value="/Resources/Javascript/LoginJS.js" />"></script>
    <title>Document</title>
</head>
<body>

    <button onclick="showlogin()">Login</button>
    <div class="container">
      <div class="modal" id="LoginModal">
        <div class="form">
          <div class="subform">
            <div id="LoginForm" style="transition: all 1s">
              <h1 class="tit">Login</h1>
              <div class="bd">
                <input
                  type="text"
                  class="ip"
                  id="LUser"
                  oninput="jsc()"
                  placeholder="User Name"
                />
                <button class="bt" onclick="rm(1)">
                  <img
                    id="LIUser"
                    src='<c:url value= "/Resources/Image/add.png"/>'
                    class="ripbt"
                    alt=""
                  />
                </button>
              </div>
              <div class="bd">
                <input
                  type="password"
                  class="ip"
                  id="LPass"
                  oninput="jsc()"
                  placeholder="PassWord"
                />
                <button class="bt" onclick="rm(2)">
                  <img
                    id="LIPass"
                    src='<c:url value= "/Resources/Image/add.png"/>'
                    class="ripbt"
                    alt=""
                  />
                 
                </button>
              </div>
            </div>

            <!--SignUp-->
            <div style="display: none; transition: all 1s" id="SignupForm">
              <h1 class="tit">Sign Up</h1>
              <div class="bd">
                <input
                  type="text"
                  class="ip"
                  id="SUser"
                  oninput="jsc()"
                  placeholder="User Name"
                />
                <button class="bt" onclick="rm(3)">
                  <img
                    id="SIUser"
                    src='<c:url value= "/Resources/Image/add.png"/>'
                    class="ripbt"
                    alt=""
                  />
                 
                </button>
              </div>
              <div class="bd">
                <input
                  type="password"
                  class="ip"
                  id="SPass"
                  oninput="jsc()"
                  placeholder="PassWord"
                />
                <button class="bt" onclick="rm(4)">
                  <img
                    id="SIPass"
                     src='<c:url value= "/Resources/Image/add.png"/>'
                    class="ripbt"
                    alt=""
                  />
                
                </button>
              </div>
              <div class="bd">
                <input
                  type="password"
                  class="ip"
                  id="SPass2"
                  oninput="jsc()"
                  placeholder="Confirm PassWord"
                />
                <button class="bt" onclick="rm(5)">
                  <img
                    id="SIPass2"
                     src='<c:url value= "/Resources/Image/add.png"/>'
                    class="ripbt"
                    alt=""
                  />
               
                </button>
              </div>
            </div>
            <!---->

            <div class="bbtn">
              <button onclick="SignUp(1)" class="botbut">Sign In</button>
              <button
                onclick="SignUp(0)"
                class="botbut"
                style="background-color: rgba(64, 227, 93, 0.77)"
              >
                Sign Up
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script type="text/javascript">
  </script>
</html>
