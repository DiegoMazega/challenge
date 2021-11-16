// ignore_for_file: file_names
// ignore_for_file: avoid_print

import 'package:flutter/material.dart';
import 'package:viasoft/screens/CadastrarPessoa.dart';
import 'package:viasoft/screens/ListaFuncionarios.dart';
import 'package:viasoft/screens/ListarEnderecos.dart';
import 'package:viasoft/screens/ListarPessoas.dart';
import 'package:viasoft/widgets/CustomAppBar.dart';

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBars(titleText: "Viasoft"),
      body: Container(
        padding: const EdgeInsets.all(40),
        child: Center(
          child: Column(
              children: [
                ElevatedButton(
                  child: const Text("Cadastrar Uma Pessoa"),
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => const CadastarPessoa()),
                    );
                  },
                ),
                ElevatedButton(
                  child: const Text("Listar Pessoas"),
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => const ListarPessoas()),
                    );
                  },
                ),
                ElevatedButton(
                  child: const Text("Listar Funcionarios"),
                  onPressed: () {
                   Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => const ListaFuncionarios()),
                    );
                  },
                ),
                ElevatedButton(
                  child: const Text("Listar Endereços"),
                  onPressed: () {
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => const ListarEnderecos()),
                    );
                  },
                ),
              ],
              crossAxisAlignment: CrossAxisAlignment.stretch,
              mainAxisAlignment: MainAxisAlignment.spaceAround),
        ),
      ),
    );
  }
}
