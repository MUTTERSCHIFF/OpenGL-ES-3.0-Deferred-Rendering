/*! @file graphics.h
 *  @brief OpenGL interface
 *  @copyright Copyright (c) 2013 Kyle Weicht. All rights reserved.
 */
#ifndef __graphics_h__
#define __graphics_h__

#include <stdint.h>
#include "vec_math.h"

typedef struct Graphics Graphics;
typedef struct Mesh Mesh;
typedef struct Texture Texture;

Graphics* create_graphics(int width, int height);
void destroy_graphics(Graphics* graphics);

void render_graphics(Graphics* graphics);
Mesh* cube_mesh(Graphics* graphics);
Mesh* quad_mesh(Graphics* graphics);

Texture* load_texture(Graphics* graphics, const char* filename);
void destroy_texture(Texture* texture);

Mesh* create_mesh(Graphics* graphics, const char* filename);
void destroy_mesh(Mesh* mesh);

void set_view_transform(Graphics* graphics, Transform view);
void add_render_command(Graphics* graphics, Mesh* mesh, Texture* diffuse, Transform transform);

#endif /* include guard */
