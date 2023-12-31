/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.accenture.controller;

import java.util.List;
import com.accenture.dto.ModelApiResponse;
import com.accenture.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-24T12:37:11.498+05:30[Asia/Calcutta]")
@Validated
@Api(value = "UserProducer", description = "the UserProducer API")
public interface UserProducerApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /v1/user-producer : Create user in master DB
     * Create user in master DB.
     *
     * @param userDto Created user object (optional)
     * @return successful operation (status code 201)
     */
    @ApiOperation(value = "Create user in master DB", nickname = "createUser", notes = "Create user in master DB.", response = ModelApiResponse.class, tags={ "user-producer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "successful operation", response = ModelApiResponse.class) })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/v1/user-producer",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ModelApiResponse> _createUser(@ApiParam(value = "Created user object") @Valid @RequestBody(required = false) UserDto userDto) {
        return createUser(userDto);
    }

    // Override this method
    default  ResponseEntity<ModelApiResponse> createUser(UserDto userDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /v1/user-producer/createWithList : Creates list of users with given input array
     * Creates list of users with given input array
     *
     * @param userDto  (optional)
     * @return successful operation (status code 201)
     */
    @ApiOperation(value = "Creates list of users with given input array", nickname = "createUsersWithListInput", notes = "Creates list of users with given input array", response = ModelApiResponse.class, tags={ "user-producer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "successful operation", response = ModelApiResponse.class) })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/v1/user-producer/createWithList",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<ModelApiResponse> _createUsersWithListInput(@ApiParam(value = "") @Valid @RequestBody(required = false) List<UserDto> userDto) {
        return createUsersWithListInput(userDto);
    }

    // Override this method
    default  ResponseEntity<ModelApiResponse> createUsersWithListInput(List<UserDto> userDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * DELETE /v1/user-producer/{userId} : Delete user by ID
     * Delete user by ID
     *
     * @param userId ID of the user to be deleted (required)
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Delete user by ID", nickname = "deleteUserById", notes = "Delete user by ID", response = ModelApiResponse.class, tags={ "user-producer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = ModelApiResponse.class) })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/v1/user-producer/{userId}",
        produces = { "application/json" }
    )
    default ResponseEntity<ModelApiResponse> _deleteUserById(@ApiParam(value = "ID of the user to be deleted", required = true) @PathVariable("userId") String userId) {
        return deleteUserById(userId);
    }

    // Override this method
    default  ResponseEntity<ModelApiResponse> deleteUserById(String userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : 0, \"message\" : \"message\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /v1/user-producer/all : Returns all Users
     * Returns all Users
     *
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Returns all Users", nickname = "getAllUsers", notes = "Returns all Users", response = UserDto.class, responseContainer = "List", tags={ "user-producer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserDto.class, responseContainer = "List") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/v1/user-producer/all",
        produces = { "application/json" }
    )
    default ResponseEntity<List<UserDto>> _getAllUsers() {
        return getAllUsers();
    }

    // Override this method
    default  ResponseEntity<List<UserDto>> getAllUsers() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"James\", \"lastName\" : \"Bond\", \"phone\" : \"12345\", \"id\" : 10, \"department\" : \"IT\", \"email\" : \"james@gmail.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /v1/user-producer/{userId} : Find user by ID
     * Find user by ID.
     *
     * @param userId ID of user to be fetched (required)
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Find user by ID", nickname = "getUserById", notes = "Find user by ID.", response = UserDto.class, tags={ "user-producer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserDto.class) })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/v1/user-producer/{userId}",
        produces = { "application/json" }
    )
    default ResponseEntity<UserDto> _getUserById(@ApiParam(value = "ID of user to be fetched", required = true) @PathVariable("userId") String userId) {
        return getUserById(userId);
    }

    // Override this method
    default  ResponseEntity<UserDto> getUserById(String userId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"James\", \"lastName\" : \"Bond\", \"phone\" : \"12345\", \"id\" : 10, \"department\" : \"IT\", \"email\" : \"james@gmail.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /v1/user-producer/{userId} : Update user
     * Update user.
     *
     * @param userId name that need to be deleted (required)
     * @param userDto Update an existent user in the store (optional)
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Update user", nickname = "updateUserById", notes = "Update user.", response = UserDto.class, tags={ "user-producer", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = UserDto.class) })
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/v1/user-producer/{userId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UserDto> _updateUserById(@ApiParam(value = "name that need to be deleted", required = true) @PathVariable("userId") String userId,@ApiParam(value = "Update an existent user in the store") @Valid @RequestBody(required = false) UserDto userDto) {
        return updateUserById(userId, userDto);
    }

    // Override this method
    default  ResponseEntity<UserDto> updateUserById(String userId, UserDto userDto) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"James\", \"lastName\" : \"Bond\", \"phone\" : \"12345\", \"id\" : 10, \"department\" : \"IT\", \"email\" : \"james@gmail.com\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
