package edge.wfa.ip

import edge.wfa.BaseTest

/**
  * Created by medge on 1/21/16.
  */
class IpUtilsTest extends BaseTest {

  "isIpVersion4()" should "return true for a valid IPv4 address" in {
    IpUtils.isIpVersion4("192.168.1.1") shouldBe true
    IpUtils.isIpVersion4("192.168.111.111") shouldBe true
    IpUtils.isIpVersion4("255.255.255.255") shouldBe true
    IpUtils.isIpVersion4("1.1.1.1") shouldBe true
    IpUtils.isIpVersion4("1.12.123.0") shouldBe true
  }

  "isIpVersion4()" should "return false for an invalid IPv4 address" in {
    IpUtils.isIpVersion4("192.168.1") shouldBe false
    IpUtils.isIpVersion4("2000:123A:abcd:73g3::") shouldBe false

    // TODO no subnet support yet. Remove when supported
    IpUtils.isIpVersion4("255.255.255.255/16") shouldBe false

    IpUtils.isIpVersion4("Hello, World") shouldBe false
    IpUtils.isIpVersion4("1") shouldBe false
  }

  "ipToLong()" should "produce the correct integer representation for an IPv4 Address" in {
    IpUtils.iptoLong("192.168.0.1") shouldBe 3232235521L
    IpUtils.iptoLong("255.255.255.255") shouldBe 4294967295L
  }
}
