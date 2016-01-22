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

  "isIpVersion6()" should "return true for a valid IPv6 address" in {
    IpUtils.isIpVersion6("2000:123A:ABCD:73F3:1234:1234:1234:1234") shouldBe true
    IpUtils.isIpVersion6("2000:123a:abcd:73f3:1234:1234:1234:1234") shouldBe true
    IpUtils.isIpVersion6("2000:123a:ABcD:73f3:1234:1234:1234:1234") shouldBe true
  }

  "isIpVersion6()" should "return false for an invalid IPv6 address" in {
    IpUtils.isIpVersion6("2345:GGGG:FFFF:HHHH:ZZZZ:123D:1234:1234") shouldBe false
    IpUtils.isIpVersion6("192.168.1") shouldBe false
    IpUtils.isIpVersion6("255.255.255.255/16") shouldBe false
    IpUtils.isIpVersion6("Hello, World") shouldBe false
    IpUtils.isIpVersion6("1") shouldBe false
  }

  "ipToLong()" should "produce the correct integer representation for an IPv4 Address" in {
    IpUtils.ipToInt("192.168.0.1") shouldBe 3232235521L
    IpUtils.ipToInt("255.255.255.255") shouldBe 4294967295L
  }

  "ipToLong()" should "produce the correct integer representation for an IPv6 Address" in {
    IpUtils.ipToInt("2000:123A:ABCD:73F3:1234:1234:1234:1234") shouldBe BigInt("42531122511263480549358276640189233760")
  }
}
