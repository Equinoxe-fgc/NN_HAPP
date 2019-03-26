package com.diana.nn_happ;
/*
	How to use:

		// Create and open a device to play effects
		// This should be done only once per application

		Device device = Device.newDevice();

		// Create an IVT buffer with the exported effect definitions

		IVTBuffer ivtBuffer = new IVTBuffer(calendario.ivt);

		// Play one of the effect defined in the IVTBuffer

		device.playIVTEffect(ivtBuffer, calendario.Balon);

		// When the device is not needed anymore,
		// it must be closed to avoid resource leak

		device.close();

		// For more details, refer to the ImmVibe API Reference.

*/

class calendario
{
	public static final int Balon = 0;

	public static final int Balon_fuerte = 1;

	public static final byte[] ivt = 
	{
		(byte)0x01, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x7a, (byte)0x00, (byte)0x2a, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x6d, (byte)0x00, (byte)0xf2, (byte)0xe2, (byte)0x00, (byte)0x00,
		(byte)0xe2, (byte)0x00, (byte)0x00, (byte)0xe5, (byte)0x01, (byte)0xf1, (byte)0xe0, (byte)0x01,
		(byte)0xe2, (byte)0x00, (byte)0x00, (byte)0xd0, (byte)0x00, (byte)0xc8, (byte)0xf1, (byte)0xe0,
		(byte)0x01, (byte)0xe2, (byte)0x01, (byte)0x37, (byte)0xd0, (byte)0x00, (byte)0xc8, (byte)0xf1,
		(byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x02, (byte)0xdf, (byte)0xd0, (byte)0x00, (byte)0x96,
		(byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x03, (byte)0xad, (byte)0xd0, (byte)0x00,
		(byte)0x96, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x04, (byte)0x7a, (byte)0xd0,
		(byte)0x00, (byte)0x96, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x06, (byte)0x0e,
		(byte)0xd0, (byte)0x00, (byte)0x7d, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x06,
		(byte)0xc9, (byte)0xd0, (byte)0x00, (byte)0x7d, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2,
		(byte)0x07, (byte)0x84, (byte)0xd0, (byte)0x00, (byte)0x7d, (byte)0xf1, (byte)0xe0, (byte)0x01,
		(byte)0xe2, (byte)0x08, (byte)0x45, (byte)0xd0, (byte)0x00, (byte)0x7d, (byte)0xf1, (byte)0xe0,
		(byte)0x01, (byte)0xe2, (byte)0x09, (byte)0xc7, (byte)0xd0, (byte)0x00, (byte)0xaf, (byte)0xf1,
		(byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x0a, (byte)0xa8, (byte)0xd0, (byte)0x00, (byte)0xaf,
		(byte)0xff, (byte)0x20, (byte)0x0c, (byte)0x00, (byte)0x00, (byte)0x7f, (byte)0x00, (byte)0x00,
		(byte)0x81, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x0c, (byte)0x00, (byte)0x42, (byte)0x00,
		(byte)0x61, (byte)0x00, (byte)0x6c, (byte)0x00, (byte)0x6f, (byte)0x00, (byte)0x6e, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x42, (byte)0x00, (byte)0x61, (byte)0x00, (byte)0x6c, (byte)0x00,
		(byte)0x6f, (byte)0x00, (byte)0x6e, (byte)0x00, (byte)0x20, (byte)0x00, (byte)0x66, (byte)0x00,
		(byte)0x75, (byte)0x00, (byte)0x65, (byte)0x00, (byte)0x72, (byte)0x00, (byte)0x74, (byte)0x00,
		(byte)0x65, (byte)0x00, (byte)0x00, (byte)0x00
	};
}
