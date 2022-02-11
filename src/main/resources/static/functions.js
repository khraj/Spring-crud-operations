function success(){
  alert("User Added successfully...!");
}

function update(){
  alert("User Updated successfully...!");
}

function signup(){
  alert("signed Up Successfully...!);
}

var deleteLinks = document.querySelectorAll('.delete');

for (var i = 0; i < deleteLinks.length; i++) {
  deleteLinks[i].addEventListener('click', function(event) {
      event.preventDefault();

      var choice = confirm(this.getAttribute('data-confirm'));

      if (choice) {
        window.location.href = this.getAttribute('href');
      }
  });
}