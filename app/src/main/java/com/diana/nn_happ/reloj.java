package uma.diana.nn_happ;
/*
	How to use:

		// Create and open a device to play effects
		// This should be done only once per application

		Device device = Device.newDevice();

		// Create an IVT buffer with the exported effect definitions

		IVTBuffer ivtBuffer = new IVTBuffer(reloj.ivt);

		// Play one of the effect defined in the IVTBuffer

		device.playIVTEffect(ivtBuffer, reloj.Lascuatro);

		// When the device is not needed anymore,
		// it must be closed to avoid resource leak

		device.close();

		// For more details, refer to the ImmVibe API Reference.

*/

class reloj
{
	public static final int Lascuatro = 0;

	public static final int Dong = 1;

	public static final byte[] ivt = 
	{
		(byte)0x01, (byte)0x00, (byte)0x02, (byte)0x00, (byte)0x26, (byte)0x00, (byte)0x22, (byte)0x00,
		(byte)0x00, (byte)0x00, (byte)0x19, (byte)0x00, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2,
		(byte)0x00, (byte)0x00, (byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x03, (byte)0xe8,
		(byte)0xf1, (byte)0xe0, (byte)0x01, (byte)0xe2, (byte)0x07, (byte)0xd0, (byte)0xf1, (byte)0xe0,
		(byte)0x01, (byte)0xe2, (byte)0x0b, (byte)0xb8, (byte)0xff, (byte)0x20, (byte)0x12, (byte)0x00,
		(byte)0x00, (byte)0x7f, (byte)0x00, (byte)0x00, (byte)0xc1, (byte)0x00, (byte)0x00, (byte)0x00,
		(byte)0x14, (byte)0x00, (byte)0x4c, (byte)0x00, (byte)0x61, (byte)0x00, (byte)0x73, (byte)0x00,
		(byte)0x63, (byte)0x00, (byte)0x75, (byte)0x00, (byte)0x61, (byte)0x00, (byte)0x74, (byte)0x00,
		(byte)0x72, (byte)0x00, (byte)0x6f, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x44, (byte)0x00,
		(byte)0x6f, (byte)0x00, (byte)0x6e, (byte)0x00, (byte)0x67, (byte)0x00, (byte)0x00, (byte)0x00
	};
}
