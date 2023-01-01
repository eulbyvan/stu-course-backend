package com.eulbyvan.stucoursebackend;

import com.eulbyvan.stucoursebackend.model.entity.Role;
import com.eulbyvan.stucoursebackend.model.dto.response.ApiError;
import com.eulbyvan.stucoursebackend.model.dto.response.GenericResponse;
import com.eulbyvan.stucoursebackend.repo.IRoleRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author stu (https://www.eulbyvan.com/)
 * @version 1.0
 * @since 01/01/2023
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RoleControllerTest {
    private static final String API_1_0_ROLES = "/api/1.0/roles";
    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    IRoleRepo roleRepo;

    @Before
    public void cleanup() {
        roleRepo.deleteAll();
    }

    @Test
    public void postRole_whenRoleIsValid_receiveHttpStatusCreated() {
        Role role = createValidRole();
        ResponseEntity<Object> response = postSignup(role, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void postRole_whenRoleIsValid_roleSavedToDatabase() {
        Role role = createValidRole();
        postSignup(role, Object.class);
        assertThat(roleRepo.count()).isEqualTo(1);
    }

    @Test
    public void postRole_whenRoleIsValid_recieveSuccessMessage() {
        Role role = createValidRole();
        ResponseEntity<GenericResponse> response = postSignup(role, GenericResponse.class);
        assertThat(response.getBody().getMessage()).isNotNull();
    }

    @Test
    public void postRole_whenRoleIsValid_recieveCreated() {
        Role role = createValidRole();
        ResponseEntity<GenericResponse> response = postSignup(role, GenericResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void postRole_whenRoleHasNullName_receiveBadRequest() {
        Role role = createValidRole();
        role.setName(null);
        ResponseEntity<Object> response = postSignup(role, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postRole_whenRoleHasBlankName_receiveBadRequest() {
        Role role = createValidRole();
        role.setName("");
        ResponseEntity<Object> response = postSignup(role, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postRole_whenRoleHasNameWithLessThanRequired_receiveBadRequest() {
        Role role = createValidRole();
        role.setName("ab");
        ResponseEntity<Object> response = postSignup(role, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postRole_whenRoleHasNameExceedsTheLengthLimit_receiveBadRequest() {
        Role role = createValidRole();
        String valueOf256Chars = IntStream.rangeClosed(1, 256).mapToObj(x -> "a").collect(Collectors.joining());
        role.setName(valueOf256Chars);
        ResponseEntity<Object> response = postSignup(role, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postRole_whenRoleIsInvalid_receiveApiError() {
        Role role = new Role();
        ResponseEntity<ApiError> response = postSignup(role, ApiError.class);
        assertThat(response.getBody().getUrl()).isEqualTo(API_1_0_ROLES);
    }

    @Test
    public void postRole_whenRoleIsInvalid_receiveApiErrorWithValidationError() {
        Role role = new Role();
        ResponseEntity<ApiError> response = postSignup(role, ApiError.class);
        assertThat(response.getBody().getValidationErrors().size()).isEqualTo(3);
    }

    @Test
    public void postRole_whenRoleHasNullName_receiveMessageOfNullErrorForName() {
        Role role = new Role();
        role.setName(null);
        ResponseEntity<ApiError> response = postSignup(role, ApiError.class);
        Map<String, String> validationErrors = response.getBody().getValidationErrors();
        assertThat(validationErrors.get("rolename")).isEqualTo("rolename cannot be null");
    }

    @Test
    public void postRole_whenRoleHasInvalidLengthName_receiveGenericMessageOfSizeError() {
        Role role = new Role();
        role.setName("ab");
        ResponseEntity<ApiError> response = postSignup(role, ApiError.class);
        Map<String, String> validationErrors = response.getBody().getValidationErrors();
        assertThat(validationErrors.get("rolename")).isEqualTo("it must have minimum 3 and maximum 255 characters");
    }

    @Test
    public void postRole_whenAnotherRoleHasSameName_receiveBadRequest() {
        roleRepo.save(createValidRole());
        Role role = createValidRole();
        ResponseEntity<Object> response = postSignup(role, Object.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    public void postRole_whenAnotherRoleHasSameName_receiveMessageOfDuplicateName() {
        roleRepo.save(createValidRole());
        Role role = createValidRole();
        ResponseEntity<ApiError> response = postSignup(role, ApiError.class);
        Map<String, String> validationErrors = response.getBody().getValidationErrors();
        assertThat(validationErrors.get("rolename")).isEqualTo("role already exists");
    }

    public <T> ResponseEntity<T> postSignup(Object request, Class<T> response) {
        return testRestTemplate.postForEntity(API_1_0_ROLES, request, response);
    }

//    @Test
//    public void getRoles_receiveSuccessMessage() {
//        List<Role> dummyRoles = new ArrayList<>();
//        dummyRoles.add(new Role());
//
//        List<Role> actualRoles = roleRepo.findAll();
//
//        assertThat()
//    }

    private static Role createValidRole() {
        Role role = new Role();
        role.setName("USER");
        return role;
    }
}
