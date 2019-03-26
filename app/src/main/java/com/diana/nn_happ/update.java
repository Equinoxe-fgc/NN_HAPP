package com.diana.nn_happ;
/*
	How to use:

		// Create and open a device to play effects
		// This should be done only once per application

		Device device = Device.newDevice();

		// Create an IVT buffer with the exported effect definitions

		IVTBuffer ivtBuffer = new IVTBuffer(update.ivt);

		// Play one of the effect defined in the IVTBuffer

		device.playIVTEffect(ivtBuffer, update.Brian);

		// When the device is not needed anymore,
		// it must be closed to avoid resource leak

		device.close();

		// For more details, refer to the ImmVibe API Reference.

*/

class update
{
	public static final int Brian = 0;

	public static final int Brian1 = 1;

	public static final byte[] ivt = 
	{
		(byte)0x01, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x46, (byte)0x00, (byte)0x1e, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x31, (byte)0x00, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2,
		(byte)0x00, (byte)0x00, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x00, (byte)0xc8,
		(byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x03, (byte)0xe9, (byte)0xf1, (byte)0xe0,
		(byte)0x01, (byte)0xe2, (byte)0x04, (byte)0x7f, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2,
		(byte)0x05, (byte)0x79, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x06, (byte)0x0f,
		(byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x07, (byte)0x09, (byte)0xf1, (byte)0xe0,
		(byte)0x01, (byte)0xe2, (byte)0x07, (byte)0x9f, (byte)0xff, (byte)0x30, (byte)0x00, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x20, (byte)0x05, (byte)0x00,
		(byte)0x00, (byte)0x7f, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x0c, (byte)0x00, (byte)0x42, (byte)0x00, (byte)0x72, (byte)0x00, (byte)0x69, (byte)0x00,
		(byte)0x61, (byte)0x00, (byte)0x6e, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x42, (byte)0x00,
		(byte)0x72, (byte)0x00, (byte)0x69, (byte)0x00, (byte)0x61, (byte)0x00, (byte)0x6e, (byte)0x00,
		(byte)0x31, (byte)0x00, (byte)0x00, (byte)0x00
	};
}
