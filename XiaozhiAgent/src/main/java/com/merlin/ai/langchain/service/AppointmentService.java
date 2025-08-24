package com.merlin.ai.langchain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.merlin.ai.langchain.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}
