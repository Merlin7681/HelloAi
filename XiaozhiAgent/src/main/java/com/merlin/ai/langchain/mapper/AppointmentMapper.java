package com.merlin.ai.langchain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.merlin.ai.langchain.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper extends BaseMapper<Appointment> {
}
