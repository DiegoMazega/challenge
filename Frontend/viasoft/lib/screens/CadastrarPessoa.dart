// ignore_for_file: file_names
// ignore_for_file: avoid_print

import 'package:flutter/material.dart';
import 'package:viasoft/screens/Home.dart';
import 'package:viasoft/services/Requests.dart';
import 'package:viasoft/widgets/CustomAppBar.dart';
import 'package:viasoft/widgets/CustomTextField.dart';

class CadastarPessoa extends StatefulWidget {
  const CadastarPessoa({Key? key}) : super(key: key);

  @override
  _CadastarPessoaState createState() => _CadastarPessoaState();
}

class _CadastarPessoaState extends State<CadastarPessoa> {
  final TextEditingController _pessoaController = TextEditingController();
  final TextEditingController _idadeController = TextEditingController();
  final TextEditingController _telefoneCasaController = TextEditingController();
  final TextEditingController _telefoneMovelController =
      TextEditingController();
  final TextEditingController _nomeCidadeController = TextEditingController();
  final TextEditingController _nomeBairroController = TextEditingController();
  final TextEditingController _cepController = TextEditingController();
  final TextEditingController _cargoController = TextEditingController();
  final TextEditingController _nomeFuncionarioController =
      TextEditingController();
  final TextEditingController _nomeEmpresaController = TextEditingController();

  final FocusNode textSecondFocusNode = FocusNode();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBars(titleText: "Cadastrar Pessoas"),
        body: Container(
          padding: const EdgeInsets.all(20),
          child: ListView(
            children: [
              Column(
                children: [
                  CustomTextField(
                    autoCorret: true,
                    fieldController: _pessoaController,
                    label: "Nome Da Pessoa",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: false,
                    last: false,
                    textSize: 50,
                    textHint: "",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _idadeController,
                    label: "Idade",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: true,
                    last: false,
                    textSize: 3,
                    textHint: "",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _telefoneCasaController,
                    label: "Telefone Casa",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: true,
                    last: false,
                    textSize: 11,
                    textHint: "(dd) 99999-9999",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _telefoneMovelController,
                    label: "Telefone Móvel",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: true,
                    last: false,
                    textSize: 11,
                    textHint: "(dd) 99999-9999",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _nomeCidadeController,
                    label: "Nome Da Cidade",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: false,
                    last: false,
                    textSize: 50,
                    textHint: "",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _nomeBairroController,
                    label: "Nome Do Bairro",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: false,
                    last: false,
                    textSize: 50,
                    textHint: "",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _cepController,
                    label: "CEP",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: true,
                    last: false,
                    textSize: 8,
                    textHint: "99.999-999",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _cargoController,
                    label: "Cargo",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: false,
                    last: false,
                    textSize: 50,
                    textHint: "",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _nomeFuncionarioController,
                    label: "Nome Do Funcionário",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: false,
                    last: false,
                    textSize: 50,
                    textHint: "",
                  ),
                  CustomTextField(
                    autoCorret: false,
                    fieldController: _nomeEmpresaController,
                    label: "Nome Da Empresa",
                    obscure: false,
                    valuePadding: 10,
                    onlyNumbers: false,
                    last: true,
                    textSize: 50,
                    textHint: "",
                  ),
                  Padding(
                    padding: const EdgeInsets.only(top: 10),
                    child: ElevatedButton(
                      child: const Text(
                        "Cadastrar",
                        textAlign: TextAlign.center,
                      ),
                      onPressed: () {
                        Requests.cadastrar(
                                nomePessoa: _pessoaController.text,
                                idade: _idadeController.text,
                                telefoneCasa: _telefoneCasaController.text,
                                telefoneMovel: _telefoneMovelController.text,
                                nomeCidade: _nomeCidadeController.text,
                                nomeBairro: _nomeBairroController.text,
                                cep: _cepController.text,
                                cargo: _cargoController.text,
                                nomeFuncionario:
                                    _nomeFuncionarioController.text,
                                nomeEmpresa: _nomeEmpresaController.text)
                            .then((value) {
                          String textSnack;
                          if (value == 400) {
                            textSnack = "Nome Já Cadastrado";
                          } else {
                            textSnack = value == 201
                                ? "Pessoa Cadastrada"
                                : "Erro ao cadastrar Pessoa, revise os Campos, por favor";
                          }
                          final snackBar = SnackBar(
                            content: Text(textSnack),
                            action: SnackBarAction(
                              label: 'OK',
                              onPressed: () {},
                            ),
                          );

                          // Find the ScaffoldMessenger in the widget tree
                          // and use it to show a SnackBar.
                          ScaffoldMessenger.of(context).showSnackBar(snackBar);

                          if (value == 201) {
                            Navigator.pop(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => const Home()),
                            );
                          }
                        });
                      },
                    ),
                  )
                ],
                crossAxisAlignment: CrossAxisAlignment.stretch,
              )
            ],
          ),
        ));
  }
}
