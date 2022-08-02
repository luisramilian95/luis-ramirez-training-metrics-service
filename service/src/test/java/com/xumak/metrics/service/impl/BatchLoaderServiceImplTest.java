package com.xumak.metrics.service.impl;
import com.xumak.metrics.dao.BatchLoaderDAO;
import com.xumak.metrics.model.dto.AppResponse;
import com.xumak.metrics.model.dto.BatchLoaderDTO;
import com.xumak.metrics.service.IMetricService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BatchLoaderServiceImplTest {

    @InjectMocks
    BatchLoadServiceImpl service;

    @Mock
    BatchLoaderDAO dao;

    @DisplayName("Test get BatchLoader by id")
    @Test
    public void testGetById() {
        Long id = 1L;
        BatchLoaderDTO dto = new BatchLoaderDTO();
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
        BatchLoaderDTO dto = new BatchLoaderDTO();
        dto.setFileName("fileName.txt");
        Mockito.when(dao.save(dto)).thenReturn(true);
        AppResponse response = service.persist(dto);
        assertTrue(response.isStatus());
    }

    @DisplayName("Test not persist BatchLoader")
    @Test
    public void testNotPersist(){
        BatchLoaderDTO dto = new BatchLoaderDTO();
        dto.setFileName("fileName.txt");
        Mockito.when(dao.save(dto)).thenReturn(false);
        AppResponse response = service.persist(dto);
        assertFalse(response.isStatus());
    }

    @DisplayName("Test get BatchLoaders between timestamp")
    @Test
    public void testFindBatchLoaderByTimestamp(){
        Date start = new Date();
        Date end = new Date();

        List<BatchLoaderDTO> dtos = new ArrayList<>();

        BatchLoaderDTO dto1 = new BatchLoaderDTO();
        dto1.setId(1L);
        dto1.setFileName("file1.txt");
        dto1.setTimestamp(start);
        dtos.add(dto1);

        BatchLoaderDTO dto2 = new BatchLoaderDTO();
        dto2.setId(2L);
        dto2.setFileName("file2.txt");
        dto2.setTimestamp(end);
        dtos.add(dto2);

        Mockito.when(dao.getByTimestamp(start, end)).thenReturn(dtos);

        int expected = 2;

        assertEquals(expected, service.getByTimestamps(start, end).size());

    }

}
