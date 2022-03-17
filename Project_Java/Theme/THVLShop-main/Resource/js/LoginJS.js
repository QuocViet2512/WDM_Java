function RotateImg(img, val, option) {
  if (option == 0) {
    document.getElementById("" + img + "").style.transform =
      $("#" + val + "").val() == "" ? "rotate(0deg)" : "rotate(45deg)";
  } else {
    document.getElementById("" + val + "").value = "";
    document.getElementById("" + img + "").style.transform = "rotate(0deg)";
  }
}

function jsc() {
  RotateImg("LIUser", "LUser", 0);
  RotateImg("LIPass", "LPass", 0);
  RotateImg("SIUser", "SUser", 0);
  RotateImg("SIPass", "SPass", 0);
  RotateImg("SIPass2", "SPass2", 0);
}
function rm(option) {
  switch (option) {
    case 1:
      RotateImg("LIUser", "LUser", 1);
      break;
    case 2:
      RotateImg("LIPass", "LPass", 1);
      break;
    case 3:
      RotateImg("SIUser", "SUser", 1);
      break;
    case 4:
      RotateImg("SIPass", "SPass", 1);
      break;
    case 5:
      RotateImg("SIPass2", "SPass2", 1);
      break;
    default:
      break;
  }
}
function SignUp(option) {
  var SignIn = document.getElementById("LoginForm");
  var SignUp = document.getElementById("SignupForm");
  if (option == 0) {
    if (SignUp.style.display == "block") {
      alert("SignUp_EV");
    } else {
      SignUp.style.display = "block";
      SignIn.style.display = "none";
    }
  }
  if (option == 1) {
    if (SignIn.style.display == "block") {
      alert("SignIn_EV");
    } else {
      SignUp.style.display = "none";
      SignIn.style.display = "block";
    }
  }
}

function showlogin() {
  document.querySelector("#LoginModal").style.display = "block";
}

window.onclick = function (event) {
  if (event.target == document.querySelector("#LoginModal")) {
    document.querySelector("#LoginModal").style.display = "none";
  }
};
