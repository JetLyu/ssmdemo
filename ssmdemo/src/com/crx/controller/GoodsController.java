package com.crx.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.crx.pojo.Goods;
import com.crx.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("goods")
public class GoodsController {
	@Resource
	private GoodsService gs;
	
	@RequestMapping("findAll")
	public String findAll(Model model,@RequestParam(required = true,defaultValue = "1")int page) {//当前页
		int size=6;//每页显示数量
		PageHelper.startPage(page,size);
		List<Goods> goods = gs.findAll();
		PageInfo<Goods> info = new PageInfo<Goods>(goods,size);
		model.addAttribute("info", info);
		//model.addAttribute("url","dsdsds.action");
		return "../goods_list";
	}

	@RequestMapping("insert")
	public String aaa(Goods goods,MultipartFile upfile) {
	    goods.setImg(upload(upfile));
		gs.insert(goods);
		return "redirect:/goods/findAll.action";
	}
	public String upload(MultipartFile upfile) {
		String filename = upfile.getOriginalFilename();
		String newname="";
		if(!"".equals(filename)) {
			newname = UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
			File f = new File("d://aa//"+newname);
			try {
				upfile.transferTo(f);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return newname;
	}
	@RequestMapping("delete")
	public String delete(int id) {
		gs.delete(id);
		return "redirect:/goods/findAll.action";
	}
	@RequestMapping("yupdate")
	public String findById(int id,Model model) {
		Goods goods =gs.findById(id);
		model.addAttribute("updategoods", goods);
		return "../goods_update";
	}
	@RequestMapping("update")
	public String update(Goods goods,MultipartFile upfile) {
		//1.没修改图片
		//1.拿id去把原来的goods查出来 得到原来的图片名
		//2.在页面记录原来的goods的img属性
		//2.修改了图片
		if(!"".equals(upfile.getOriginalFilename())) {
			String newname = upload(upfile);
			goods.setImg(newname);
		}
	
		gs.update(goods);
		return "redirect:/goods/findAll.action";
	}
	@RequestMapping("findByName")
	public String findByName(String name,Model model) {
		List<Goods> goods = gs.findByName(name);
		model.addAttribute("goods", goods);
		return "../goods_list";
	}
}

