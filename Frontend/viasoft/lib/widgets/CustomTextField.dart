// ignore_for_file: file_names
// ignore_for_file: avoid_print

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class CustomTextField extends Padding {
  final TextEditingController fieldController;
  final bool autoCorret;
  final bool obscure;
  final String label;
  final double valuePadding;
  final bool onlyNumbers;
  final bool last;
  final int textSize;
  final String textHint;

  CustomTextField(
      {Key? key,
      required this.fieldController,
      required this.autoCorret,
      required this.obscure,
      required this.label,
      required this.valuePadding,
      required this.onlyNumbers,
      required this.last,
      required this.textSize,
      required this.textHint
      })
      : super(
            padding: EdgeInsets.only(top: valuePadding),
            key: key,
            child: TextField(
              autocorrect: autoCorret,
              obscureText: obscure,
              controller: fieldController,
              decoration: InputDecoration(
                border: const OutlineInputBorder(),
                labelText: label,
                hintText: textHint
              ),
              inputFormatters: <TextInputFormatter>[
                onlyNumbers ? FilteringTextInputFormatter.digitsOnly:FilteringTextInputFormatter.deny(""),
                LengthLimitingTextInputFormatter(textSize),
                ],
                keyboardType: onlyNumbers ? TextInputType.number: TextInputType.text,
                textInputAction: last ? TextInputAction.done:TextInputAction.next,
            ));
}
