package com.xumak.metrics.service.impl;

import com.xumak.metrics.dao.PersonResolutionDAO;
import com.xumak.metrics.model.dto.AppResponse;
import com.xumak.metrics.model.dto.PersonResolutionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PersonResolutionServiceImplTest {

    @InjectMocks
    PersonResolutionServiceImpl service;

    @Mock
    PersonResolutionDAO dao;

    @DisplayName("Test get BatchLoader by id")
    @Test
    public void testGetById() {
        Long id = 1L;
        PersonResolutionDTO dto = new PersonResolutionDTO();
        dto.setId(id);
        Mockito.when(dao.getById(id)).thenReturn(dto);
        assertEquals(dto, service.getById(id));
    }

    @DisplayName("Test get BatchLoader by id not found")
    @Test
    public void testGetByIdNotFound() {
        Long id = 1L;
        Mockito.when(dao.getById(id)).thenReturn(null);
        assertNull(service.getById(id));
    }

    @DisplayName("Test persist BatchLoader")
    @Test
    public void testPersist(){
        PersonResolutionDTO dto = new PersonResolutionDTO();
        dto.setEndpoint("url.com");
        Mockito.when(dao.save(dto)).thenReturn(true);
        AppResponse response = service.persist(dto);
        assertTrue(response.isStatus());
    }

    @DisplayName("Test not persist BatchLoader")
    @Test
    public void testNotPersist(){
        PersonResolutionDTO dto = new PersonResolutionDTO();
        dto.setEndpoint("url.com");
        Mockito.when(dao.save(dto)).thenReturn(false);
        AppResponse response = service.persist(dto);
        assertFalse(response.isStatus());
    }

    @DisplayName("Test get BatchLoaders between timestamp")
    @Test
    public void testFindBatchLoaderByTimestamp(){
        Date start = new Date();
        Date end = new Date();

        List<PersonResolutionDTO> dtos = new ArrayList<>();

        PersonResolutionDTO dto1 = new PersonResolutionDTO();
        dto1.setId(1L);
        dto1.setEndpoint("url1.com");
        dto1.setTimestamp(start);
        dtos.add(dto1);

        PersonResolutionDTO dto2 = new PersonResolutionDTO();
        dto2.setId(2L);
        dto2.setEndpoint("url2.com");
        dto2.setTimestamp(end);
        dtos.add(dto2);

        Mockito.when(dao.getByTimestamp(start, end)).thenReturn(dtos);

        int expected = 2;

        assertEquals(expected, service.getByTimestamps(start, end).size());

    }

}
