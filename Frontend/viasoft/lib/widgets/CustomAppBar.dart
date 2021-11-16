// ignore_for_file: file_names
// ignore_for_file: avoid_print

import 'package:flutter/material.dart';

class AppBars extends AppBar {
  final String titleText;

  AppBars({Key? key, required this.titleText})
      : super(
          key: key,
          title: Text(titleText),
          centerTitle: true,
          backgroundColor: const Color.fromRGBO(255, 10, 10, 0.8),
        );
}
