function success(){
  alert("User Added successfully...!");
}

function update(){
  alert("User Updated successfully...!");
}

function signup(){
  alert("signed Up Successfully...!")
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

/*function isempty(){
    let userId=document.getElementById("userId").value;
    let username=document.getElementById("username").value;
    let password=document.getElementById("password").value;
    let email=document.getElementById("email").value;

    if(username != "" && password!="" userId != "" && email !=""){
        document.getElementById("btn").removeAttribute("disabled");
    }
}*/


/*
(function() {
$('form > input').keyup(function() {
    var empty = false;
    $('form > input').each(function() {
        if ($(this).val() == '')
        {
            empty = true;
        }
    });
    if (empty)
    {
        $('#register').attr('disabled', 'disabled');
    }
   else
    {
        $('#register').removeAttr('disabled');
    }
});
})()*/
