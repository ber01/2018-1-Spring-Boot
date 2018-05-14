package org.zerock;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Member;
import org.zerock.domain.Profile;
import org.zerock.persistence.MemberRepository;
import org.zerock.persistence.ProfileRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class ProfileTests {

	@Autowired
	MemberRepository memberRepo;

	@Autowired
	ProfileRepository profileRepo;

	@Test
	public void testInsertMembers() {

		IntStream.range(1, 101).forEach(i -> {
			Member member = new Member();
			member.setUid("user" + i);
			member.setUpw("pw" + i);
			member.setUname("사용자" + i);

			memberRepo.save(member);

		});

	}// end method

	@Test
	public void testInsertProfile() {

		Member member = new Member();
		member.setUid("user1");

		for (int i = 1; i < 5; i++) {

			Profile profile1 = new Profile();
			profile1.setFname("face" + i + ".jpg");

			if (i == 1) {
				profile1.setCurrent(true);
			}

			profile1.setMember(member);

			profileRepo.save(profile1);

		}
	}

	@Test
	public void testFetchJoin1() {

		List<Object[]> result = memberRepo.getMemberWithProfileCount("user1");

		result.forEach(arr -> System.out.println(Arrays.toString(arr)));

	}

	@Test
	public void testFetchJoin2() {

		List<Object[]> result = memberRepo.getMemberWithProfile("user1");

		result.forEach(arr -> System.out.println(Arrays.toString(arr)));

	}

}
