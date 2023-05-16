FROM public.ecr.aws/amazoncorretto/amazoncorretto:17

COPY *.jar app.jar

EXPOSE ${PRODUCTS_PORT}

CMD [ "java", "-jar","-Dspring.profiles.active=dev", "/app.jar" ]
