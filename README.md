<h3 align="left">Leetcode:</h3>

![Leetcode Stats](https://leetcard.jacoblin.cool/artemsemeniuk77?ext=activity)













package model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "A simple Car object", contentMediaType = "application/json")
public class Car {

    @Schema(description = "Unique identifier", example = "1", type = "long", format = "int64")
    private Long id;

    @Schema(description = "Brand of a car", example = "Toyota", requiredMode = Schema.RequiredMode.REQUIRED)
    private String brand;

    @Schema(description = "Current status", allowableValues = {"available", "pending", "sold"})
    private String status;

    public Car() {}

    public Car(Long id, String brand, String status) {
        this.id = id;
        this.brand = brand;
        this.status = status;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


package model;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cars endpoint", description = "REST endpoint for car model")
public class CarHandler {
    @Operation(summary = "Find car by Id", description = "Returns a single car")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successful operation",
                    content = @Content(schema = @Schema(implementation = Car.class))
            ),
            @ApiResponse(responseCode = "404", description = "Car not found")
    })
    public Car findCarById(@Parameter(description = "Id of Car to return", required = true, name = "carId", in = ParameterIn.PATH)Long carId) {
        return new Car(carId, "Honda", "sold");
    }
}



import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.integration.api.OpenAPIConfiguration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.*;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import model.Car;
import model.CarHandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException, NoSuchMethodException {
        OpenAPIConfiguration config = new SwaggerConfiguration()
                .resourcePackages(Collections.singleton("model"))
                .prettyPrint(true);


        Map<String, Schema> schemas = ModelConverters.getInstance().read(Car.class);
        OpenAPI openAPI = new OpenAPI();
        openAPI.setInfo(new Info()
                .title("Car store API")
                .version("1.0.0")
                .description("Simple car API"));


        openAPI.components(new Components()
                .addSchemas("Car", schemas.get("Car")));

        Method method = CarHandler.class.getMethod("findCarById", Long.class);
        io.swagger.v3.oas.annotations.Operation op = method.getAnnotation(io.swagger.v3.oas.annotations.Operation.class);
        io.swagger.v3.oas.annotations.Parameter par = method.getAnnotation(io.swagger.v3.oas.annotations.Parameter.class);
        io.swagger.v3.oas.annotations.responses.ApiResponses res = method.getAnnotation(io.swagger.v3.oas.annotations.responses.ApiResponses.class);

//        io.swagger.v3.oas.models.Operation operation =
//                AnnotationsUtils.getAnnotation(Operation.class, res);
//
//
//        OperationParser.getApiResponses(res, null, null, new Components(), null);

        ApiResponses responses = new ApiResponses();

        for (int i = 0; i < res.value().length; i++) {
            io.swagger.v3.oas.annotations.responses.ApiResponse apiResponse = res.value()[i];

            MediaType mediaType = new MediaType();


            Content content;
            if (apiResponse.responseCode().equals("200"))
            {
                mediaType.setSchema(schemas.get("Car"));
                content = new Content().addMediaType("application/json", mediaType);
            }
            else
            {
                Map<String, Schema> map = new LinkedHashMap<>();
                map.put("message", new StringSchema());
                map.put("code", new IntegerSchema());
                Schema schema = new Schema<>();
                schema.setProperties(map);
                mediaType.setSchema(schema);
                content = new Content().addMediaType("application/json", mediaType);
            }

            ApiResponse response = new ApiResponse()
                    .description(apiResponse.description())
                    .content(content);

            responses.addApiResponse(apiResponse.responseCode(), response);
        }
        Operation operation = new Operation();
        operation.setSummary(op.summary());

        Parameter parameterAnnotation = method.getParameters()[0].getAnnotation(Parameter.class);
        io.swagger.v3.oas.models.parameters.Parameter parameter = new io.swagger.v3.oas.models.parameters.Parameter();
        parameter.setDescription(parameterAnnotation.description());
        parameter.setRequired(parameterAnnotation.required());
        parameter.setIn(parameterAnnotation.in().toString());
        parameter.setName(parameterAnnotation.name());

        operation.setParameters(List.of(parameter));
        operation.setDescription(op.description());
        operation.setResponses(responses);
//       // operation.setResponses(new ApiResponses().addApiResponse("test", res.extensions()));
//        Operation operation2 = new Operation().description(res.value()[0].description());
//        Operation operation3 = new Operation().description(res.value()[1].description());

        openAPI.path("/car/id", new PathItem().get(operation));

        String yaml = Yaml.pretty(openAPI);
        try (java.io.PrintWriter out = new java.io.PrintWriter("openapi.yaml")) {
            out.println(yaml);
        }
    }
}



    <dependencies>
        <dependency>
            <groupId>io.swagger.core.v3</groupId>
            <artifactId>swagger-models</artifactId>
            <version>2.2.45</version>
        </dependency>

        <dependency>
            <groupId>io.swagger.core.v3</groupId>
            <artifactId>swagger-integration</artifactId>
            <version>2.2.45</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>io.swagger.core.v3</groupId>
            <artifactId>swagger-annotations</artifactId>
            <version>2.2.45</version>
            <scope>compile</scope>
        </dependency>

    </dependencies>





















