package com.hp.system.mapper;

import com.hp.common.base.BaseMapper;
import com.hp.system.domain.SysOss;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * 文件上传
 */
@MapperScan
public interface SysOssMapper extends BaseMapper<SysOss>
{
}
