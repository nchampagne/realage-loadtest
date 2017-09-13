package com.sharecare.realage

final case class Answer(value: String, text: String, factId: String, answerId: String, answersToClear: List[String], answerImage: String)

final case class Question(id: String, displayLabel: Map[String, String], displayLabelOrder: List[String], factDataType: Map[String, String], questionText: String, answers: List[Answer], required: Boolean, `type`: String, chartOption: List[String], chartLabel: List[String], previousValues: Map[String, String], moreInfoTitle: String, moreInfoBody: String)

final case class Page(num: String, name: String, moduleId: String, questionGroupId: String, introText: String, completionErrorText: String, pageNumber: String, maxPageNumber: Int, questions: List[Question])

final object PageOfAnswers {
  type FactEntry      = Map[String, String]
  type PageOfAnswers  = Map[String, List[FactEntry]]
}
