package com.diana.nn_happ;
/*
	How to use:

		// Create and open a device to play effects
		// This should be done only once per application

		Device device = Device.newDevice();

		// Create an IVT buffer with the exported effect definitions

		IVTBuffer ivtBuffer = new IVTBuffer(googleplus.ivt);

		// Play one of the effect defined in the IVTBuffer

		device.playIVTEffect(ivtBuffer, googleplus.Tambor);

		// When the device is not needed anymore,
		// it must be closed to avoid resource leak

		device.close();

		// For more details, refer to the ImmVibe API Reference.

*/

class googleplus
{
	public static final int Tambor = 0;

	public static final int Tambor_fuerte = 1;

	public static final int Tambor_suave = 2;

	public static final byte[] ivt = 
	{
		(byte)0x01, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x56, (byte)0x00, (byte)0x4a, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x40, (byte)0x00, (byte)0x48, (byte)0x00, (byte)0xf1, (byte)0xe0,
		(byte)0x01, (byte)0xe2, (byte)0x00, (byte)0x00, (byte)0xd0, (byte)0x00, (byte)0x32, (byte)0xf1,
		(byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x00, (byte)0x51, (byte)0xd0, (byte)0x00, (byte)0x32,
		(byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x00, (byte)0xa8, (byte)0xd0, (byte)0x00,
		(byte)0x32, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x00, (byte)0xff, (byte)0xd0,
		(byte)0x00, (byte)0x5d, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x04, (byte)0xac,
		(byte)0xd0, (byte)0x00, (byte)0x64, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x08,
		(byte)0xa2, (byte)0xd0, (byte)0x00, (byte)0x64, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2,
		(byte)0x0c, (byte)0x93, (byte)0xd0, (byte)0x00, (byte)0x64, (byte)0xff, (byte)0x20, (byte)0x0c,
		(byte)0x00, (byte)0x00, (byte)0x7f, (byte)0x00, (byte)0x00, (byte)0x81, (byte)0x20, (byte)0x07,
		(byte)0x00, (byte)0x00, (byte)0x33, (byte)0x00, (byte)0x00, (byte)0xd1, (byte)0x00, (byte)0x00,
		(byte)0x0e, (byte)0x00, (byte)0x2a, (byte)0x00, (byte)0x54, (byte)0x00, (byte)0x61, (byte)0x00,
		(byte)0x6d, (byte)0x00, (byte)0x62, (byte)0x00, (byte)0x6f, (byte)0x00, (byte)0x72, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x54, (byte)0x00, (byte)0x61, (byte)0x00, (byte)0x6d, (byte)0x00,
		(byte)0x62, (byte)0x00, (byte)0x6f, (byte)0x00, (byte)0x72, (byte)0x00, (byte)0x20, (byte)0x00,
		(byte)0x66, (byte)0x00, (byte)0x75, (byte)0x00, (byte)0x65, (byte)0x00, (byte)0x72, (byte)0x00,
		(byte)0x74, (byte)0x00, (byte)0x65, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x54, (byte)0x00,
		(byte)0x61, (byte)0x00, (byte)0x6d, (byte)0x00, (byte)0x62, (byte)0x00, (byte)0x6f, (byte)0x00,
		(byte)0x72, (byte)0x00, (byte)0x20, (byte)0x00, (byte)0x73, (byte)0x00, (byte)0x75, (byte)0x00,
		(byte)0x61, (byte)0x00, (byte)0x76, (byte)0x00, (byte)0x65, (byte)0x00, (byte)0x00, (byte)0x00
	};
}
