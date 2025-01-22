package com.example.ejemplo02.Service.Impl;

import com.example.ejemplo02.Service.SumaService;
import org.springframework.stereotype.Service;

@Service
public class SumaServiceImpl implements SumaService {

    @Override
    public int suma(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public String saludo(String nombre) {
        return "";
    }
}
