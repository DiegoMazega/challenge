// ignore_for_file: file_names
// ignore_for_file: avoid_print

import 'dart:convert';

import 'package:viasoft/Models/Endereco.dart';
import 'package:viasoft/Models/Funcionario.dart';
import 'package:viasoft/Models/Pessoa.dart';
import 'package:viasoft/Models/PessoaPost.dart';
import 'package:http/http.dart' as http;

class Requests {
  static final _headers = {"Content-Type": "application/json"};
  static const String _ipPorta = "http://10.0.0.104:6969/";

  static Future<int> cadastrar(
      {required String nomePessoa,
      required String idade,
      required String telefoneCasa,
      required String telefoneMovel,
      required String nomeCidade,
      required String nomeBairro,
      required String cep,
      required String cargo,
      required String nomeFuncionario,
      required String nomeEmpresa}) async {
    PessoaPost post = PessoaPost(
        nomePessoa: nomePessoa,
        idade: idade,
        telefoneCasa: telefoneCasa,
        telefoneMovel: telefoneMovel,
        nomeCidade: nomeCidade,
        nomeBairro: nomeBairro,
        cep: cep,
        cargo: cargo,
        nomeFuncionario: nomeFuncionario,
        nomeEmpresa: nomeEmpresa);

    Uri _url = Uri.parse(_ipPorta + "pessoas/insert");
    var postBody = jsonEncode(post.toJson());
    var response = await http.post(_url, body: postBody, headers: _headers);
    int statuscode = response.statusCode;

    return statuscode;
  }

  static Future<List<Pessoa>> getPessoaList() async {
    List<Pessoa> pessoas = [];

    Uri _url = Uri.parse(_ipPorta + "pessoas/");
    http.Response response = await http.get(_url);
    var bodyResponse = jsonDecode(response.body);
    for (var pessoa in bodyResponse) {
      Funcionario func = Funcionario(
          pessoa["funcionario"]["id"],
          pessoa["funcionario"]["cargo"],
          pessoa["funcionario"]["nome"],
          pessoa["funcionario"]["empresa"]);
      List<Endereco> enderecos = [];
      for(var endereco in pessoa["enderecos"]){
      Endereco end = Endereco(endereco["id"], endereco["cidadeNome"], endereco["cidadeBairro"], endereco["cep"]);
      enderecos.add(end);
      }
      Pessoa persona = Pessoa(
          pessoa["id"],
          pessoa["nome"],
          pessoa["idade"],
          pessoa["telefones"].cast<String>(),
          enderecos,
          func);
      pessoas.add(persona);
    }

    return pessoas;
  }

  static Future<List<Funcionario>> getFuncionarioList() async {
    List<Funcionario> funcionarios = [];

    Uri _url = Uri.parse(_ipPorta + "funcionarios/");
    http.Response response = await http.get(_url);
    var bodyResponse = jsonDecode(response.body);
    for (var func in bodyResponse) {
      Funcionario funcionario =
          Funcionario(func["id"], func["cargo"], func["nome"], func["empresa"]);
      funcionarios.add(funcionario);
    }

    return funcionarios;
  }

  static Future<List<Endereco>> getEnderecoList() async {
    List<Endereco> enderecos = [];

    Uri _url = Uri.parse(_ipPorta + "enderecos/");
    http.Response response = await http.get(_url);
    var bodyResponse = jsonDecode(response.body);
    for (var end in bodyResponse) {
      Endereco endereco = Endereco(
          end["id"], end["cidadeNome"], end["cidadeBairro"], end["cep"]);
      enderecos.add(endereco);
    }

    return enderecos;
  }

  static Future<int> deletarPessoa({required int id}) async{
    Uri _url = Uri.parse(_ipPorta + "pessoas/$id");
    http.Response response = await http.delete(_url);

    return response.statusCode;
  }
}
