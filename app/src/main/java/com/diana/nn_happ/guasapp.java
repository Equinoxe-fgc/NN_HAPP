package com.diana.nn_happ;
/*
	How to use:

		// Create and open a device to play effects
		// This should be done only once per application

		Device device = Device.newDevice();

		// Create an IVT buffer with the exported effect definitions

		IVTBuffer ivtBuffer = new IVTBuffer(guasapp.ivt);

		// Play one of the effect defined in the IVTBuffer

		device.playIVTEffect(ivtBuffer, guasapp.Rafaga);

		// When the device is not needed anymore,
		// it must be closed to avoid resource leak

		device.close();

		// For more details, refer to the ImmVibe API Reference.

*/

class guasapp
{
	public static final int Rafaga = 0;

	public static final byte[] ivt = 
	{
		(byte)0x01, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x0a, (byte)0x00, (byte)0x10, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x20, (byte)0x9c, (byte)0x00, (byte)0x00, (byte)0x7f, (byte)0x11,
		(byte)0x22, (byte)0x41, (byte)0x00, (byte)0x00, (byte)0x52, (byte)0x00, (byte)0x61, (byte)0x00,
		(byte)0x66, (byte)0x00, (byte)0x61, (byte)0x00, (byte)0x67, (byte)0x00, (byte)0x61, (byte)0x00,
		(byte)0x00, (byte)0x00
	};
}
