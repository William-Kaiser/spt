package com.william.admin.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * mybatis-plus代码生成器
 * 
 * @author theodo
 * @Date 2017/10/21 12:38
 */
public class MyBatisPlusGenerator {

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\spt\\spt\\admin\\src\\main\\java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        // .setKotlin(true) 是否生成 kotlin 代码
        gc.setAuthor("william");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                //processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3307/ssm?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        //strategy.setInclude(new String[] { "user" }); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        // strategy.setSuperEntityClass("com.william.spt.core.BaseEntity");
        //自定义实体，公共字段
        strategy.setSuperEntityColumns(new String[] { "createDate", "updateDate" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.william.spt.core.BaseMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.william.spt.core.BaseService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.william.spt.core.BaseServiceImpl");
        //自定义 controller 父类
        strategy.setSuperControllerClass("com.william.core.base.BaseController");
        // 实体是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 实体是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuilderModel(false);
        // 生成 RestController 风格
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
//      pc.setParent(null);
//		pc.setModuleName("test");
        pc.setEntity("com.william.admin.entity");
        pc.setMapper("com.william.admin.mapper");
        pc.setXml("com.william.admin.mapper.xml");
        pc.setService("com.william.admin.service");
        pc.setServiceImpl("com.william.admin.service.impl");
        pc.setController("com.william.admin.controller");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}