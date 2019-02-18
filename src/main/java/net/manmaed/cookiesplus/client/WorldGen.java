package net.manmaed.cookiesplus.client;

import net.manmaed.cookiesplus.blocks.BlockGinger;
import net.manmaed.cookiesplus.blocks.CookieBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by manmaed on 26/02/2017.
 */


public class WorldGen implements IWorldGenerator
{

    public static WorldGen INSTANCE = new WorldGen();
    /*private WorldGenMinable ginger;*/


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        int ChunkX16 = chunkX * 16;
        int ChunkZ16 = chunkZ * 16;

        switch (world.provider.getDimension()) {
            case -1:
                GenerateOreInNether(world, random, ChunkX16, ChunkZ16);
                break;
            case 0:
                //GenerateOreInOverworld(world, random, ChunkX16, ChunkZ16);
                GenerateOreInOverworld(world, random, chunkX, chunkZ);
                break;
            case 1:
                GenerateOreInEnd(world, random, ChunkX16, ChunkZ16);
                break;
        }
    }

    public void GenerateOreInEnd(World world, Random random, int X, int Z) {
    }


    public void GenerateOreInOverworld(World world, Random random, int chunkX, int chunkZ) {
        int xPos = chunkX * 16 + 8;
        int zPos = chunkZ * 16 + 8;

        BlockPos chunkPos = new BlockPos(xPos, 0, zPos);

        Biome biome = world.getChunk(chunkPos).getBiome(chunkPos, world.getBiomeProvider());

            if (random.nextInt(5) == 0 && this.goodClimate(biome, 0.11f, 1.0f, 0.11f, 2f)) {
                final int posX = xPos + random.nextInt(16);
                final int posY = random.nextInt(128) + 64;
                final int posZ = zPos + random.nextInt(16);
                final BlockPos newPos = new BlockPos(posX, posY, posZ);

                if (newPos != null) {
                    this.generateGinger(world, random, newPos);
                    this.generateGinger(world, random, newPos);
                }
            }
        }

        public void GenerateOreInNether (World world, Random random,int X, int Z)
        {
            //   addOreSpawn()
        }

    public boolean generateGinger(World world, Random random, BlockPos position)
    {
        IBlockState state = CookieBlocks.gingerBlock.getDefaultState().withProperty(BlockGinger.AGE, 7);

        for (int tries = 0; tries < 64; tries++)
        {
            BlockPos blockpos = position.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (world.isAirBlock(blockpos) && CookieBlocks.gingerBlock.canBlockStay(world, blockpos, state))
            {
                world.setBlockState(blockpos, state, 2);
                //LogHelper.info(blockpos);
            }
        }

        return true;
    }

        public boolean goodClimate (Biome biome,float minTemp, float maxTemp, float minRain, float maxRain)
        {
            float temp = biome.getDefaultTemperature();
            float rain = biome.getRainfall();

            if (minTemp <= temp && temp <= maxTemp && minRain <= rain && rain <= maxRain) {
                return true;
            }

            return false;
        }
    }
