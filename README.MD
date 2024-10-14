Данный проект - fork проекта CleverReflection, в котором  alpha версия валидатора 
реализована с помощью паттерна Chain of Responsibility.

Базовый класс - ru.clevertec.validation.Validator.

Цепочка создается в статическом методе Validator.of(),
применяется в классе - Converter, метод - mappingJsonToDomain.

Также в проекте применяются:
 - builder - ContainerData.ContainerBuilder;
 - factory - ConverterFactory, NodeConverterFactory, ParserFactory:
 - state  - NodeConverter, ConverterToJson, ParserJson;





