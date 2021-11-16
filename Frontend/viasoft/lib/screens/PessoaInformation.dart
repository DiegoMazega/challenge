// ignore_for_file: file_names
// ignore_for_file: avoid_print

import 'package:flutter/material.dart';
import 'package:viasoft/Models/Endereco.dart';
import 'package:viasoft/Models/Pessoa.dart';
import 'package:viasoft/screens/Home.dart';
import 'package:viasoft/services/Requests.dart';
import 'package:viasoft/widgets/CustomAppBar.dart';

class PessoaInformation extends StatelessWidget {
  final Pessoa pessoa;
  const PessoaInformation({Key? key, required this.pessoa}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    Color _color = Colors.black;
    Offset _offset = const Offset(2.0, 2.0);
    double _blurRadius = 2.0;
    double _width = MediaQuery.of(context).size.width * 0.95;
    double _height = MediaQuery.of(context).size.height * 0.2;

    return Scaffold(
        appBar: AppBars(titleText: pessoa.nome),
        body: SingleChildScrollView(
          child: Column(
            children: <Widget>[
              Container(
                  width: _width,
                  height: _height,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5.0),
                    color: Colors.white,
                    boxShadow: [
                      BoxShadow(
                        color: _color,
                        blurRadius: _blurRadius,
                        spreadRadius: 0.0,
                        offset: _offset, // shadow direction: bottom right
                      )
                    ],
                  ),
                  padding: const EdgeInsets.all(10),
                  margin: const EdgeInsets.only(top: 10, bottom: 5),
                  child: SingleChildScrollView(
                    child: Column(
                      children: <Widget>[
                        const Text("Pessoa",
                            style: TextStyle(
                                fontSize: 18, fontWeight: FontWeight.bold)),
                        Wrap(
                          children: [
                            const Text(
                              "Nome: ",
                              style: TextStyle(
                                  fontSize: 15, fontWeight: FontWeight.bold),
                            ),
                            Text(pessoa.nome),
                          ],
                        ),
                        Wrap(
                          children: [
                            const Text(
                              "Idade: ",
                              style: TextStyle(
                                  fontSize: 15, fontWeight: FontWeight.bold),
                            ),
                            Text(pessoa.getIdade.toString()),
                          ],
                        ),
                        Wrap(
                          children: [
                            const Text(
                              "Telefones: ",
                              style: TextStyle(
                                  fontSize: 15, fontWeight: FontWeight.bold),
                            ),
                            Text(pessoa.telefones
                                .toString()
                                .replaceFirst("[", "")
                                .replaceFirst("]", "")),
                          ],
                        )
                      ],
                      mainAxisAlignment: MainAxisAlignment.start,
                      crossAxisAlignment: CrossAxisAlignment.start,
                    ),
                  )),
              Container(
                  width: _width,
                  height: _height,
                  decoration: BoxDecoration(
                    borderRadius: BorderRadius.circular(5.0),
                    color: Colors.white,
                    boxShadow: [
                      BoxShadow(
                        color: _color,
                        blurRadius: _blurRadius,
                        spreadRadius: 0.0,
                        offset: _offset, // shadow direction: bottom right
                      )
                    ],
                  ),
                  padding: const EdgeInsets.all(10),
                  margin: const EdgeInsets.only(top: 10, bottom: 5),
                  child: SingleChildScrollView(
                    child: Column(
                      children: <Widget>[
                        const Text("Funcionario",
                            style: TextStyle(
                                fontSize: 18, fontWeight: FontWeight.bold)),
                        Wrap(
                          children: [
                            const Text(
                              "Cargo: ",
                              style: TextStyle(
                                  fontSize: 15, fontWeight: FontWeight.bold),
                            ),
                            Text(pessoa.funcionario.nome),
                          ],
                        ),
                        Wrap(
                          children: [
                            const Text(
                              "Nome: ",
                              style: TextStyle(
                                  fontSize: 15, fontWeight: FontWeight.bold),
                            ),
                            Text(pessoa.funcionario.nome),
                          ],
                        ),
                        Wrap(
                          children: [
                            const Text(
                              "Empresa: ",
                              style: TextStyle(
                                  fontSize: 15, fontWeight: FontWeight.bold),
                            ),
                            Text(pessoa.funcionario.empresa),
                          ],
                        )
                      ],
                      mainAxisAlignment: MainAxisAlignment.start,
                      crossAxisAlignment: CrossAxisAlignment.start,
                    ),
                  )),
              ListView.builder(
                  itemCount: pessoa.enderecos.length,
                  physics: const NeverScrollableScrollPhysics(),
                  shrinkWrap: true,
                  itemBuilder: (context, index) {
                    Endereco end = pessoa.enderecos[index];
                    return Container(
                        width: _width,
                        height: _height,
                        decoration: BoxDecoration(
                          borderRadius: BorderRadius.circular(5.0),
                          color: Colors.white,
                          boxShadow: [
                            BoxShadow(
                              color: _color,
                              blurRadius: _blurRadius,
                              spreadRadius: 0.0,
                              offset: _offset, // shadow direction: bottom right
                            )
                          ],
                        ),
                        padding: const EdgeInsets.all(10),
                        margin: const EdgeInsets.only(top: 10, bottom: 5),
                        child: SingleChildScrollView(
                          child: Column(
                            children: <Widget>[
                              const Text("Endereço",
                                  style: TextStyle(
                                      fontSize: 18,
                                      fontWeight: FontWeight.bold)),
                              Wrap(
                                children: [
                                  const Text(
                                    "Cidade: ",
                                    style: TextStyle(
                                        fontSize: 15,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  Text(end.cidadeNome),
                                ],
                              ),
                              Wrap(
                                children: [
                                  const Text(
                                    "Bairro: ",
                                    style: TextStyle(
                                        fontSize: 15,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  Text(end.cidadeBairro),
                                ],
                              ),
                              Wrap(
                                children: [
                                  const Text(
                                    "CEP: ",
                                    style: TextStyle(
                                        fontSize: 15,
                                        fontWeight: FontWeight.bold),
                                  ),
                                  Text(end.cep),
                                ],
                              )
                            ],
                            mainAxisAlignment: MainAxisAlignment.start,
                            crossAxisAlignment: CrossAxisAlignment.start,
                          ),
                        ));
                  }),
                  ElevatedButton(
                    onPressed: (){
                      Requests.deletarPessoa(id: pessoa.id).then((value) {
                        if(value == 204){
                        Navigator.of(context).pushAndRemoveUntil(
                                MaterialPageRoute(
                                    builder: (context) =>
                                        const Home()
                              ),
                              (Route<dynamic> route) => false);
                        }else{
                          final snackBar = SnackBar(
                            content: const Text("Erro ao Apagar a Pessoa"),
                            action: SnackBarAction(
                              label: 'OK',
                              onPressed: () {},
                            ),
                          );
                          ScaffoldMessenger.of(context).showSnackBar(snackBar);
                        }
                      });
                    }, 
                    child: const Text("DELETAR PESSOA"))
            ],
            crossAxisAlignment: CrossAxisAlignment.stretch,
          ),
        ));
  }
}
