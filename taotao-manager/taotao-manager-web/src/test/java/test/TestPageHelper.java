package test;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/applicationContext-dao.xml",
		"classpath*:spring/applicationContext-service.xml",
		"classpath*:spring/applicationContext-trans.xml"})
public class TestPageHelper {
	static{
		try {
			Log4jConfigurer.initLogging("classpath:properties/log4j.properties");
		} catch (FileNotFoundException e) {
			System.err.println("Cannot Initialize log4j");  
		}
	}
	
	private static Logger log = Logger.getLogger(TestPageHelper.class);
	
	@Autowired
	TbItemMapper tbItemMapper;
	
	@Test
	public void testPageHelper() {
		TbItemExample example = new TbItemExample();
		PageHelper.startPage(1, 10);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		for (TbItem item: list) {
			//System.out.println(item.getId()+","+item.getTitle());
			log.info(item.getId()+","+item.getTitle());
		}
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//System.out.println("记录条数："+pageInfo.getTotal());
		log.info("记录条数："+pageInfo.getTotal());
	}

}
