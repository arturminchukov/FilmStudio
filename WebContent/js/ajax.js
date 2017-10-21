function loadDoc(path) {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      document.getElementById("dynamic-content").innerHTML =
      this.responseText;
    }
  };
  xhttp.open("GET", path, true);
  xhttp.send();
}