// ignore_for_file: file_names, unnecessary_getters_setters
// ignore_for_file: avoid_print

import 'package:viasoft/Models/Endereco.dart';
import 'package:viasoft/Models/Funcionario.dart';

class Pessoa{
  int _id;
  String _nome;
  int _idade;
  List<String> _telefones;
  List<Endereco> _enderecos;
  Funcionario _funcionario;
 
 Pessoa(this._id, this._nome, this._idade, this._telefones, this._enderecos, this._funcionario);

 int get id => _id;

 set id(int value) => _id = value;

  get nome => _nome;

 set nome( value) => _nome = value;

  get getIdade => _idade;

 set setIdade( idade) => _idade = idade;

  get telefones => _telefones;

 set telefones( value) => _telefones = value;

  get enderecos => _enderecos;

 set enderecos( value) => _enderecos = value;

  get funcionario => _funcionario;

 set funcionario( value) => _funcionario = value;


}