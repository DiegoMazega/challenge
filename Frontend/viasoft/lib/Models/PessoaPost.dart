// ignore_for_file: file_names
// ignore_for_file: avoid_print

class PessoaPost {
  final String nomePessoa;
  final String idade;
  final String telefoneCasa;
  final String telefoneMovel;
  final String nomeCidade;
  final String nomeBairro;
  final String cep;
  final String cargo;
  final String nomeFuncionario;
  final String nomeEmpresa;

  PessoaPost({
  required  this.nomePessoa,
  required  this.idade,
  required  this.telefoneCasa,
  required  this.telefoneMovel,
  required  this.nomeCidade,
  required  this.nomeBairro,
  required  this.cep,
  required  this.cargo,
  required  this.nomeFuncionario,
  required  this.nomeEmpresa});

  Map<String, dynamic> toJson() =>{
    "nome":  nomePessoa,
    "idade": idade,
    "telefones": [telefoneCasa, telefoneMovel],
    "cidadeNome": nomeCidade,
    "cidadeBairro": nomeBairro,
    "cep": cep,
    "cargo": cargo,
    "funcionarioNome": nomeFuncionario,
    "empresa": nomeEmpresa,

  };

}
