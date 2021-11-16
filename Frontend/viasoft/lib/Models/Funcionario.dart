// ignore_for_file: file_names, unnecessary_getters_setters
// ignore_for_file: avoid_print

class Funcionario {
  int _id;
  String _cargo;
  String _nome;
  String _empresa;
  
  
  Funcionario(this._id, this._cargo, this._nome, this._empresa);
  
  get id => _id;

 set id( value) => _id = value;

  get cargo => _cargo;

 set cargo( value) => _cargo = value;

  get nome => _nome;

 set nome( value) => _nome = value;

  get empresa => _empresa;

 set empresa( value) => _empresa = value;


}