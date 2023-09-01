package com.bitc.sec.controller;

import com.bitc.sec.service.MemberService;
import com.bitc.sec.vo.ValidationMemberVO;
import lombok.RequiredArgsConstructor;
import net.koreate.file.utils.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
public class UserController {

	private final MemberService ms;
	private final String uploadPath;
	private final ServletContext servletContext;
	private final ResourceLoader resourceLoader;

	// 완성된 실제 저장 폴더 경로
	private String realPath;

	@PostConstruct
	public void initPath() throws IOException {
		// realPath = servletContext.getRealPath(File.separator + uploadPath);
		ClassPathResource resource = new ClassPathResource("static"+ File.separator+uploadPath);
		Path path = Paths.get(resource.getURI());
		System.out.println(path.toString());
		File file = new File(path.toString());
		// System.out.println(file);

		if (!file.exists()) {
			file.mkdirs();
			System.out.println("경로 생성 완료");
		}
		System.out.println("user controller 초기화 완료");

	}

	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/user/join")
	public void join() {
	}

	@GetMapping("/user/logout")
	public void logout() {
	}

	@PostMapping("/user/uidCheck")
	@ResponseBody
	public boolean uidCheck(String u_id) throws Exception {
		boolean isCheck = ms.getMemberByID(u_id);
		System.out.println(isCheck);
		return isCheck;
	}

	@PostMapping("/user/joinPost")
	public String joinPost(ValidationMemberVO vo, MultipartFile profileImage) throws Exception {
		System.out.println(vo);
		System.out.println(profileImage);
		if (profileImage != null && !profileImage.isEmpty()) {
			String u_profile = FileUtils.uploadFile(realPath, profileImage);
			System.out.println(u_profile);
			vo.setU_profile(u_profile);
		}
		ms.memberJoin(vo);
		return "redirect:/user/login";
	}

	@GetMapping("/logOff")
	public String logOff() {
		return "/user/logOff";
	}
}
