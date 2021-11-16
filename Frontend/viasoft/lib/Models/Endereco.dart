// ignore_for_file: file_names, unnecessary_getters_setters
// ignore_for_file: avoid_print

class Endereco {
  int _id;
  String _cidadeNome;
  String _cidadeBairro;
  String _cep;

   Endereco(this._id, this._cidadeNome, this._cidadeBairro, this._cep);

  int get id => _id;

  set id(int value) => _id = value;

  get cidadeNome => _cidadeNome;

  set cidadeNome(value) => _cidadeNome = value;

  get cidadeBairro => _cidadeBairro;

  set cidadeBairro(value) => _cidadeBairro = value;

  get cep => _cep;

  set cep(value) => _cep = value;
  
}
