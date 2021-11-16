// ignore_for_file: file_names
// ignore_for_file: avoid_print

import 'package:flutter/material.dart';
import 'package:viasoft/Models/Endereco.dart';
import 'package:viasoft/services/Requests.dart';
import 'package:viasoft/widgets/CustomAppBar.dart';

class ListarEnderecos extends StatelessWidget {
  const ListarEnderecos({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    double _width = MediaQuery.of(context).size.width * 0.8;
    double _height = MediaQuery.of(context).size.height * 0.2;
    Color _color = Colors.black;
    Offset _offset = const Offset(2.0, 2.0);
    double _blurRadius = 2.0;

    return Scaffold(
        appBar: AppBars(titleText: "Lista De Enderecos"),
        body: FutureBuilder<List<Endereco>>(
          future: Requests.getEnderecoList(),
          builder: (BuildContext context, AsyncSnapshot snapshot) {
            switch (snapshot.connectionState) {
              case ConnectionState.none:
              case ConnectionState.active:
              case ConnectionState.waiting:
                return const Center(
                    child: CircularProgressIndicator(
                  semanticsLabel: 'Linear progress indicator',
                ));
              case ConnectionState.done:
                if (snapshot.hasError) {
                  const Center(child: Text("Erro ao recuperar Lista"));
                } else {
                  return ListView.builder(
                      itemCount: snapshot.data.length,
                      itemBuilder: (context, index) {
                        List<Endereco> enderecos = snapshot.data;
                        Endereco endereco = enderecos[index];
                        return SingleChildScrollView(
                            child: Container(
                                decoration: BoxDecoration(
                                  borderRadius: BorderRadius.circular(5.0),
                                  color: Colors.white,
                                  boxShadow: [
                                    BoxShadow(
                                      color: _color,
                                      blurRadius: _blurRadius,
                                      spreadRadius: 0.0,
                                      offset:
                                          _offset, // shadow direction: bottom right
                                    )
                                  ],
                                ),
                                width: _width,
                                height: _height,
                                padding: const EdgeInsets.all(10),
                                margin:
                                    const EdgeInsets.only(top: 10, bottom: 5),
                                child: Column(
                                  children: [
                                    Text("Cidade: " + endereco.cidadeNome),
                                    Text("Bairro: " + endereco.cidadeBairro),
                                    Text("CEP: " + endereco.cep)
                                  ],
                                  mainAxisAlignment: MainAxisAlignment.start,
                                  crossAxisAlignment: CrossAxisAlignment.start,
                                )));
                      });
                }
                break;
            }
            return Center(
                child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: const [],
            ));
          },
        ));
  }
}
