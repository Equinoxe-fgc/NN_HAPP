package com.diana.nn_happ;
/*
	How to use:

		// Create and open a device to play effects
		// This should be done only once per application

		Device device = Device.newDevice();

		// Create an IVT buffer with the exported effect definitions

		IVTBuffer ivtBuffer = new IVTBuffer(phone.ivt);

		// Play one of the effect defined in the IVTBuffer

		device.playIVTEffect(ivtBuffer, phone.Phone);

		// When the device is not needed anymore,
		// it must be closed to avoid resource leak

		device.close();

		// For more details, refer to the ImmVibe API Reference.

*/

class phone
{
	public static final int Phone = 0;

	public static final int Ring = 1;

	public static final int Ring1 = 2;

	public static final byte[] ivt = 
	{
		(byte)0x01, (byte)0x00, (byte)0x03, (byte)0x00, (byte)0x2c, (byte)0x00, (byte)0x28, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x16, (byte)0x00, (byte)0x1e, (byte)0x00, (byte)0xf1, (byte)0xe0,
		(byte)0x02, (byte)0xe2, (byte)0x00, (byte)0x00, (byte)0xd0, (byte)0x01, (byte)0xf7, (byte)0xf1,
		(byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x03, (byte)0x01, (byte)0xf1, (byte)0xe0, (byte)0x01,
		(byte)0xe2, (byte)0x09, (byte)0xbe, (byte)0xff, (byte)0x20, (byte)0x5d, (byte)0x00, (byte)0x00,
		(byte)0x7f, (byte)0x00, (byte)0x00, (byte)0xc1, (byte)0x20, (byte)0x25, (byte)0x00, (byte)0x00,
		(byte)0x7f, (byte)0x00, (byte)0x00, (byte)0x81, (byte)0x00, (byte)0x00, (byte)0x0c, (byte)0x00,
		(byte)0x16, (byte)0x00, (byte)0x50, (byte)0x00, (byte)0x68, (byte)0x00, (byte)0x6f, (byte)0x00,
		(byte)0x6e, (byte)0x00, (byte)0x65, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x52, (byte)0x00,
		(byte)0x69, (byte)0x00, (byte)0x6e, (byte)0x00, (byte)0x67, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x52, (byte)0x00, (byte)0x69, (byte)0x00, (byte)0x6e, (byte)0x00, (byte)0x67, (byte)0x00,
		(byte)0x31, (byte)0x00, (byte)0x00, (byte)0x00
	};
}
