package com.diana.nn_happ;
/*
	How to use:

		// Create and open a device to play effects
		// This should be done only once per application

		Device device = Device.newDevice();

		// Create an IVT buffer with the exported effect definitions

		IVTBuffer ivtBuffer = new IVTBuffer(twitter.ivt);

		// Play one of the effect defined in the IVTBuffer

		device.playIVTEffect(ivtBuffer, twitter.Timeline);

		// When the device is not needed anymore,
		// it must be closed to avoid resource leak

		device.close();

		// For more details, refer to the ImmVibe API Reference.

*/

class twitter
{
	public static final int Timeline = 0;

	public static final int Zumbido = 1;

	public static final int Zumbido2 = 2;

	public static final int Zumbido4 = 3;

	public static final int Zumbido3 = 4;

	public static final byte[] ivt = 
	{
		(byte)0x01, (byte)0x00, (byte)0x05, (byte)0x00, (byte)0x64, (byte)0x00, (byte)0x62, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x19, (byte)0x00, (byte)0x29, (byte)0x00, (byte)0x39, (byte)0x00,
		(byte)0x49, (byte)0x00, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x00, (byte)0x00,
		(byte)0xf1, (byte)0xe0, (byte)0x02, (byte)0xe2, (byte)0x03, (byte)0xc5, (byte)0xf1, (byte)0xe0,
		(byte)0x04, (byte)0xe2, (byte)0x07, (byte)0x78, (byte)0xf1, (byte)0xe0, (byte)0x03, (byte)0xe2,
		(byte)0x0b, (byte)0x2a, (byte)0xff, (byte)0x30, (byte)0xe8, (byte)0x03, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x20, (byte)0x3e, (byte)0x00, (byte)0x00, (byte)0x3c,
		(byte)0x00, (byte)0x00, (byte)0x81, (byte)0x30, (byte)0xe8, (byte)0x03, (byte)0x00, (byte)0x00,
		(byte)0x3c, (byte)0x14, (byte)0x00, (byte)0x20, (byte)0x3e, (byte)0x00, (byte)0x00, (byte)0x7f,
		(byte)0x00, (byte)0x00, (byte)0x81, (byte)0x30, (byte)0xb6, (byte)0x01, (byte)0x03, (byte)0x01,
		(byte)0x7f, (byte)0x00, (byte)0x00, (byte)0x20, (byte)0x3e, (byte)0x00, (byte)0x00, (byte)0x1e,
		(byte)0x00, (byte)0x00, (byte)0x81, (byte)0x30, (byte)0xe8, (byte)0x03, (byte)0x00, (byte)0x00,
		(byte)0x7f, (byte)0x14, (byte)0x00, (byte)0x20, (byte)0x3e, (byte)0x00, (byte)0x00, (byte)0x7f,
		(byte)0x00, (byte)0x00, (byte)0x81, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x12, (byte)0x00,
		(byte)0x22, (byte)0x00, (byte)0x34, (byte)0x00, (byte)0x46, (byte)0x00, (byte)0x54, (byte)0x00,
		(byte)0x69, (byte)0x00, (byte)0x6d, (byte)0x00, (byte)0x65, (byte)0x00, (byte)0x6c, (byte)0x00,
		(byte)0x69, (byte)0x00, (byte)0x6e, (byte)0x00, (byte)0x65, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x5a, (byte)0x00, (byte)0x75, (byte)0x00, (byte)0x6d, (byte)0x00, (byte)0x62, (byte)0x00,
		(byte)0x69, (byte)0x00, (byte)0x64, (byte)0x00, (byte)0x6f, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x5a, (byte)0x00, (byte)0x75, (byte)0x00, (byte)0x6d, (byte)0x00, (byte)0x62, (byte)0x00,
		(byte)0x69, (byte)0x00, (byte)0x64, (byte)0x00, (byte)0x6f, (byte)0x00, (byte)0x32, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x5a, (byte)0x00, (byte)0x75, (byte)0x00, (byte)0x6d, (byte)0x00,
		(byte)0x62, (byte)0x00, (byte)0x69, (byte)0x00, (byte)0x64, (byte)0x00, (byte)0x6f, (byte)0x00,
		(byte)0x34, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x5a, (byte)0x00, (byte)0x75, (byte)0x00,
		(byte)0x6d, (byte)0x00, (byte)0x62, (byte)0x00, (byte)0x69, (byte)0x00, (byte)0x64, (byte)0x00,
		(byte)0x6f, (byte)0x00, (byte)0x33, (byte)0x00, (byte)0x00, (byte)0x00
	};
}
