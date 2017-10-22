function logar(){
   var cpf = $("#cpf").val();
   var password = $("#password").val();
   
           $.ajax({
           type : 'POST',
           contentType: "application/json",
           url: "/inadimplencia/login/"+cpf+"/"+password+"/",
           dataType: 'json',
           cache: false,
           timeout: 600000,
           success: function(data){
                   if(data != null){
                           var usuario =  {"usuário": [{"cpf": cpf, "true": true}]};
                           var usuarioSecao = data;
                           localStorage.setItem('user', usuario);
                           localStorage.setItem('usuarioLogado', usuarioSecao);
                   }
           },
           error: function(){
                   
           }
   });
}
var cpfs = $('#cpf-js').val();
$('#cp').val(localStorage.getItem('cpf'));
$.ajax({
type : 'POST',
contentType: "application/json",
url: "/inadimplencia/gastos/"+cpfs+"/",
dataType: 'json',
cache: false,
timeout: 600000,
success: function(data){
	localStorage.setItem("cpf",data.cpf);
	$('#SaldoBancario').text(data.renda+",00");
	$('#gastoFixo').text(data.valorGastoFixo+",00");
	$('#dinheiroSobrando').text(data.renda-data.valorGastoFixo+",00");
	$('#dividaTotal').text(data.valorDividaTotal+",00");
}
});
