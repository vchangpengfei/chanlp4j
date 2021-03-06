/* Generated By:JavaCC: Do not edit this line. TermQueryParserConstants.java */
package com.chanlp4j.query;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface TermQueryParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int _NUM_CHAR = 1;
  /** RegularExpression Id. */
  int _ESCAPED_CHAR = 2;
  /** RegularExpression Id. */
  int _TERM_START_CHAR = 3;
  /** RegularExpression Id. */
  int _TERM_CHAR = 4;
  /** RegularExpression Id. */
  int _WHITESPACE = 5;
  /** RegularExpression Id. */
  int _QUOTED_CHAR = 6;
  /** RegularExpression Id. */
  int AND = 12;
  /** RegularExpression Id. */
  int OR = 13;
  /** RegularExpression Id. */
  int LPAREN = 14;
  /** RegularExpression Id. */
  int RPAREN = 15;
  /** RegularExpression Id. */
  int NOT = 16;
  /** RegularExpression Id. */
  int TERM = 17;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "<_NUM_CHAR>",
    "<_ESCAPED_CHAR>",
    "<_TERM_START_CHAR>",
    "<_TERM_CHAR>",
    "<_WHITESPACE>",
    "<_QUOTED_CHAR>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\u3000\"",
    "\"&&\"",
    "\"||\"",
    "\"(\"",
    "\")\"",
    "\"!\"",
    "<TERM>",
  };

}
